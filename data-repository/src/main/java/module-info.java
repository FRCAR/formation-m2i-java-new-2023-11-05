import com.bigcorp.project.data.contract.AddressService;
import com.bigcorp.project.data.repository.AddressServiceImpl;

/**
 * Module de calcul scientifique pour les bateaux...
 * @provides AddressService
 */
module com.bigcorp.project.data.repository{

	/**
	 * Ces classes fournissent des services de...
	 */
	exports com.bigcorp.project.data.model;
	exports com.bigcorp.project.data.repository;
	
	requires transitive com.bigcorp.project.data.contract;
	
	opens com.bigcorp.project.data.model ;
	
	provides AddressService with AddressServiceImpl;
	
}