/**
 * 
 */

package com.org.exception;

/**
 * 
 * A Renseigner.
 * @author  : mmenhour
 * @project : commons
 * @package : com.org.exception
 * @date    : 4 sept. 2016 14:47:48
 */
public class IllegalArgumentsException extends RuntimeException
{
   
   private static final long serialVersionUID = -144984032870442729L;
   
   /**
    * 
    */
   public IllegalArgumentsException()
   {
   }
   
   /**
    * @param message
    */
   public IllegalArgumentsException( String message )
   {
      super( message );
   }
   
   /**
    * @param cause
    */
   public IllegalArgumentsException( Throwable cause )
   {
      super( cause );
   }
   
   /**
    * @param message
    * @param cause
    */
   public IllegalArgumentsException( String message, Throwable cause )
   {
      super( message, cause );
   }
}
