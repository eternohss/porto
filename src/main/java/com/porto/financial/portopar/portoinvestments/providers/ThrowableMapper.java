package com.porto.financial.portopar.portoinvestments.providers;

import com.porto.financial.portopar.portoinvestments.exception.PortoSeguroException;
import com.porto.financial.portopar.portoinvestments.response.ExceptionResponse;
import org.apache.log4j.Logger;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static com.porto.financial.portopar.portoinvestments.types.ErrorMessage.ERROR_OPERATION;

/**
 * Defines an exception handler to response exception of operations. 
 * @author mangani
 */
@Provider
public class ThrowableMapper implements ExceptionMapper<Throwable> {
	
	private Logger logger = Logger.getLogger(ThrowableMapper.class);
	
	/**
	 * Creates an appropriated response.
	 * @return - {@link ExceptionResponse}.
	 */
	public Response toResponse(Throwable ex) {
		
		this.logger.error(ex.getMessage(), ex);
		
		String message = ERROR_OPERATION.error();
		Response.Status httpStatus = Response.Status.INTERNAL_SERVER_ERROR;
		
		if (ex instanceof PortoSeguroException) {
			
			PortoSeguroException portoException = (PortoSeguroException)ex;
			
			message = portoException.getMessage();
			httpStatus = portoException.getHttpStatus();
		}
		
		ExceptionResponse er = new ExceptionResponse(message);
		
		return Response
				.status(httpStatus.getStatusCode())
				.entity(er)
				.build();
	}
}
