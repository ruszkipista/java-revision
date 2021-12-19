## SAP Extensions
For SAP Patient Management the following extensions are used and/or defined:

In the SAP **Patient Profile** the FHIR standard extensions on address.line are included
- [address.line.streetName](https://simplifier.net/fhirapiofsappatientmanagementis-h/adxp-streetname)
- [address.line.houseNumber](https://simplifier.net/fhirapiofsappatientmanagementis-h/adxp-housenumber)
- [address.line.additionalLocator](https://simplifier.net/fhirapiofsappatientmanagementis-h/adxp-additionallocator) 
- [address.line.postBox](https://simplifier.net/fhirapiofsappatientmanagementis-h/adxp-postbox).

In the SAP **Encounter Profile** the SAP extensions on DepartmentOrganization and NursingOrganization are removed.
New SAP extensions are introduced for:
- [Institution](https://simplifier.net/fhirapiofsappatientmanagementis-h/institution): SAP Institution
- [Absence](https://simplifier.net/fhirapiofsappatientmanagementis-h/encounterabsence): Node with reason, period, plannedPeriod
- [subjectStatus](https://simplifier.net/fhirapiofsappatientmanagementis-h/encountersubjectstatus): in conformance to the one to be released as a standard attribute in the HL7 FHIR Encounter profile with Release 5

For the SAP **Account Profile**: 
- *ReferenceEncounter*: reference to the encounter instances that are grouped together in this account for billing purposes (extension [AccountExtensionEncounter](https://simplifier.net/fhirapiofsappatientmanagementis-h/referenceencounter))

for the SAP **Schedule Profile**: 
- *ExternalBookable*: boolean indicating whether a schedule can be booked via a portal that externals like referring physicians or patients can access (extension [externalBookable](https://simplifier.net/fhirapiofsappatientmanagementis-h/externalbookable))


Details of the structureDefinition can be found [here](https://simplifier.net/fhirapiofsappatientmanagementis-h/~resources?category=Extension)