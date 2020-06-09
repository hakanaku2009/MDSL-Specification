/*
 * generated by Xtext 2.20.0
 */
package io.mdsl.validation;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.EValidatorRegistrar;

import io.mdsl.apiDescription.ApiDescriptionPackage;
import io.mdsl.apiDescription.endpointContract;
import io.mdsl.apiDescription.serviceSpecification;

/**
 * This class contains custom validation rules. 
 *
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class EndpointContractValidator extends AbstractAPIDescriptionValidator {

	@Override
	public void register(EValidatorRegistrar registrar) {
		// not needed for classes used as ComposedCheck
	}
	
	@Check
	public void dataContractValidator(final serviceSpecification specRoot) {
		info("MDSL API Linter: checking some but not all semantic rule in " + specRoot.getName(), specRoot, ApiDescriptionPackage.Literals.SERVICE_SPECIFICATION__NAME);
	}
	
	
	@Check
	public void reportContractSize(endpointContract epc) {
		int opsInContract = epc.getOps().size();
		// String code = "API Metric";
		
		if(opsInContract>7) {
			warning(epc.getName() + " exposes " + opsInContract + " operation(s), more than a single HTTP resource can support in its unified method/verb interface", epc, ApiDescriptionPackage.Literals.ENDPOINT_CONTRACT__NAME);		
		}
		else {
			info(epc.getName() + " exposes " + opsInContract + " operation(s)", epc, ApiDescriptionPackage.Literals.ENDPOINT_CONTRACT__NAME);
		}
	}
}
