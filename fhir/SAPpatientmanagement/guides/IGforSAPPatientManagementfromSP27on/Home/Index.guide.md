# FHIR Interface for SAP Patient Management
This implementation guide describes the use cases and resources of the FHIR Interface for SAP Patient Management from the release **EhP8 SP27 (EhP7 SP39)** on,  covering FHIR Version SAP_ISH_R4_GV2.

With these support packages a new FHIR Version SAP_ISH_R4_GV2 is available. The most important changes compared to the FHIR version SAP_ISH_R4_GEN can be found in the [release notes](https://help.sap.com/viewer/1d3d6ef2cdcd47b68a8270d5e1cdbf61/618.27/en-US/e0c8a11586ca44fc8627ba4df2006960.html). In short these are:
- Introduction of "must support" flag for all profiles (see details [here](https://simplifier.net/guide/IGforSAPPatientManagementfromSP27on/Home/UseCases/Mustsupportflags.guide.md))
- Important Changes in the patient and in the encounter profiles
- Definition of SAP Terminology for some codesystems and valueSets.

Both FHIR versions, SAP_ISH_R4_GEN and SAP_ISH_R4_GV2 are supported in parallel and can be used in your custom version.

Visit the [SAP pages](https://help.sap.com/viewer/f5035f472fff4b39bce8e6abb0e62288/LATEST/en-US/7a7b01ebe05341b5925bd7179ec0e6cb.html) for more details on the SAP Patient Management FHIR interface.

In the section "integrate" of the [help portal](https://help.sap.com/viewer/product/SAP_FOR_HEALTHCARE) you can find the following **guides** (make sure that the selected release is IS-H 618 SP 027 or higher):  
- the Integration Guide for Outbound FHIR Messaging
- the Configuration Guide FHIR Interface for SAP Patient Management
- the Developer Guide for IS-H FHIR Extensibility (see [SAP note 3059437](https://launchpad.support.sap.com/#/notes/3059437))

[SAP note 2963681](https://launchpad.support.sap.com/#/notes/2963681) gives more details on the mapping for SAP Patient Management entities and attributes to FHIR resources and elements.

[Here](https://simplifier.net/fhirapiofsappatientmanagementis-h) is the link to corresponding the Simplifier project. 

{{index:root}}




{{render:FHIRAPIofSAPPatientManagementIS-H/saplogoWhite}} 