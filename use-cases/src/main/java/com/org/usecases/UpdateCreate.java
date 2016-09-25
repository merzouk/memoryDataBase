
package com.org.usecases;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases
 * @date    : 20 sept. 2016 22:52:37
 */
public interface UpdateCreate<T>
{
   /**
    * 
    * @param t
    * @return
    */
   T update( T t );
   
   /**
    * 
    * @param t
    * @return
    */
   T create( T t );
   
   
}
