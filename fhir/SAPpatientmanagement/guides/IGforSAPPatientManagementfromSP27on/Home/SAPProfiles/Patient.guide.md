### Patient 
The patient profile that SAP Patient Management supports is the following: 
{{tree:FHIRAPIofSAPPatientManagementIS-H/genericpatientv2, snapshot}}

These are the supported **search parameters**:

|Parameter|Result|Example|
|-
|identifier|Patient ID of SAP Patient Management is supported. ||
|organization|Searches for patients within a specified [institution](https://help.sap.com/saphelp_dbm800/helpdata/en/b8/ad499a237e495e92fe785f6b2fd811/content.htm?no_cache=true). Make sure you include the system and value of the organization. The result of the example request on the right will let you know that you have to narrow your search. You can do so by adding another search parameter with "&"|`GET https://<host>:<port>/<FHIR-endpoint>/Patient?organization=[valueSetName]|0001`|
|family|Searches for patients with a specified last name name|`GET https://<host>:<port>/<FHIR-endpoint>/Patient?organization=[valueSetName]|0001&family=miller`|
|given|Searches for patients with a specified first name|`GET https://<host>:<port>/<FHIR-endpoint>/Patient?organization=[valueSetName]|0001&given=john`|


