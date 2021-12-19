### Encounter
As the concepts of a FHIR encounter and an IS-H movement are not the same, a mapping between them has to be established.
The picture below depicts how FHIR encounters and IS-H movements relate to each other.
{{render:FHIRAPIofSAPPatientManagementIS-H/encountermovementmapping}} 

The main ideas are the following:
Encounters should document the reality, i.e. what really happened in terms of contact of a patient with the Healthcare provider.
This means
- Granularity is given by the capability of the current HIS systems where department, room and bed transfers can be documented
- Visits are documented as separate encounters
- Absences are kept separately (are no encounters in the sense of the above definition)

Note that there is a difference between encounters and accounts (IS-H cases):
- Encounters should be documented as-is, independently of the way they will be billed by a Patient Accounting System like IS-H
- Accounts group encounters together for a given billing scenario (f.ex. all encounters that happened in a quarter for outpatient billing in Germany).

The Encounter profile that SAP Patient Management supports is the following
{{tree:FHIRAPIofSAPPatientManagementIS-H/GenericEncounterv2, snapshot}}

