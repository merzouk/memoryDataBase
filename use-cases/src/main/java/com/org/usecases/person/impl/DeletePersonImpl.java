package com.org.usecases.person.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.org.dao.ContratDao;
import com.org.model.PersonModel;
import com.org.usecases.Deleting;

/**
 * A Renseigner.
 * @author  : admin
 * @project : use-cases
 * @package : com.org.usecases.impl
 * @date    : 20 sept. 2016 22:55:14
 */
@Service("deletePerson")
public class DeletePersonImpl implements Deleting<PersonModel, Integer>
{
   private static final Logger              logger = LoggerFactory.getLogger( DeletePersonImpl.class );
   
   @Autowired
   private ContratDao<PersonModel, Integer> personDao;
   
   /**
    * 
    * @see com.org.usecases.Deleting#deleteById(java.io.Serializable)
    */
   @Override
   public void deleteById( Integer primaryKey )
   {
      logger.info( "deleteById" );
      personDao.deleteById( primaryKey );
   }
   
   /**
    * 
    * @see com.org.usecases.Deleting#delete(java.lang.Object)
    */
   @Override
   public void delete( PersonModel t )
   {
      logger.info( "delete" );
      personDao.delete( t );
   }
}
