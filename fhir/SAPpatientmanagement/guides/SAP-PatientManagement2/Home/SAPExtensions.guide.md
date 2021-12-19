## SAP Extensions
For SAP Patient Management the following extensions are defined


for the SAP **Account Profile**: 
- *ReferenceEncounter*: reference to the encounter instances that are grouped together in this account for billing purposes (extension [AccountExtensionEncounter](https://simplifier.net/fhirapiofsappatientmanagementis-h/accountextensionencounter))

for the SAP **Encounter Profile**: 
- *NursingOrganization*: reference to the organization instance that represents the nursing organization for this encounter (extension [NursingOrganization](https://simplifier.net/fhirapiofsappatientmanagementis-h/nursingorganization))
- *DepartmentOrganization*: reference to the organization instance that represents the organization that has the responsibility as department for this encounter (extension [DepartmentOrganization](https://simplifier.net/fhirapiofsappatientmanagementis-h/departmentorganization))

for the SAP **Procedure Profile**: 
- *ReferenceAccount*: reference to the account through which the procedure will be billed

for the SAP **Schedule Profile**: 
- *ExternalBookable*: boolean indicating whether a schedule can be booked via a portal that externals like referring physicians or patients can access (extension [externalBookable](https://simplifier.net/fhirapiofsappatientmanagementis-h/externalbookable))


Details of the structureDefinition can be found [here](https://simplifier.net/fhirapiofsappatientmanagementis-h/~resources?category=Extension)