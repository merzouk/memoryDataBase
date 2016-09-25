
package com.org.usecases;

import java.io.Serializable;
import java.util.List;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases
 * @date    : 20 sept. 2016 22:50:04
 */
public interface Loading<T, I extends Serializable>
{
   /**
    * 
    * @return
    */
   List<T> getAll();
   
   /**
    * 
    * @param id
    * @return
    */
   T getById( I primaryKey );
}
