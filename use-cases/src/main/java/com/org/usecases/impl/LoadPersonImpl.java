
package com.org.usecases.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.ContratDao;
import com.org.model.PersonModel;
import com.org.usecases.LoadPerson;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases.impl
 * @date    : 20 sept. 2016 22:56:28
 */
@Service("loadPerson")
public class LoadPersonImpl implements LoadPerson<PersonModel, Integer>
{
   
   private static final Logger              logger = LoggerFactory.getLogger( LoadPersonImpl.class );
   
   @Autowired
   private ContratDao<PersonModel, Integer> personDao;
   
   /**
    * 
    * @see com.org.usecases.LoadPerson#getAll()
    */
   @Override
   public List<PersonModel> getAll()
   {
      logger.info( "getAll" );
      return personDao.getAll();
   }
   
   /**
    * 
    * @see com.org.usecases.LoadPerson#getById(java.io.Serializable)
    */
   @Override
   public PersonModel getById( Integer primaryKey )
   {
      logger.info( "getById" );
      return personDao.read( primaryKey );
   }
}
