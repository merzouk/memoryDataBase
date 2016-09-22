package com.org.usecases;

import java.io.Serializable;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases
 * @date    : 20 sept. 2016 22:53:58
 */
public interface DeletePerson<T, I extends Serializable>
{
   /**
    * 
    * @param primaryKey
    */
   void deleteById( I primaryKey );
   
   /**
    * 
    * @param t
    */
   void delete( T t );
}
