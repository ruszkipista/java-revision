## Usage of must-support flags
DETAILS TO COME
The usage of Must-support flags according to the FHIR specification (see [here](https://www.hl7.org/fhir/profiling.html#mustsupport)) has the following meaning for the profiles covered by this implementation guide:

- In the context of creating/changing FHIR resources via the REST API or inbound messaging:
    - All elements with a must-support flag will be processed and persisted by IS-H.
    - All other elements will be ignored and not persisted. .
    - Please note: Mandatory elements for the creation of FHIR resources are represented via the cardinality 1:1 and not via the must-support flag.



- In the context of reading / searching FHIR resources via the REST API or outbound messaging:
    - If the corresponding information is available, it will be provided in the corresponding element. 
    - If it is not available, it will be empty. 
