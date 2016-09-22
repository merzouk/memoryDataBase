
package com.org.exception;

/**
 * 
 * A Renseigner.
 * @author  : admin
 * @project : commons
 * @package : com.org.exception
 * @date    : 22 sept. 2016 19:22:55
 */
public class PersonRuntimeException extends RuntimeException
{
   
   private static final long serialVersionUID = 4598678758218070254L;
   
   public PersonRuntimeException()
   {
   }
   
   public PersonRuntimeException( String message )
   {
      super( message );
   }
   
   public PersonRuntimeException( Throwable cause )
   {
      super( cause );
   }
   
   public PersonRuntimeException( String message, Throwable cause )
   {
      super( message, cause );
   }
}
