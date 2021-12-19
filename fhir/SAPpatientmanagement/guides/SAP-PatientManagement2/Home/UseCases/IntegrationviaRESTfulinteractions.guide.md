### Integration via RESTful interactions
See all the supported RESTful interactions per resource on the [SAP help portal](https://help.sap.com/viewer/f5035f472fff4b39bce8e6abb0e62288/618.21/en-US/2bd62213ae224f0091fc982ffcb5018a.html). 

The table below lists all supported REST full interactions:

|Resource|RESTful interaction|Search Parameters|
|-
|Account|Update, Delete|identifier, encounter, subject|
|Appointment|Create, Read, Update, Delete|identifier|
|ChargeItemDefinition	|Read |identifier|
|Condition|Create, Read, Update, Delete|identifier, account, encounter, subject|
|Coverage|Create, Read, Update, Delete|identifier|
|Encounter|Create, Read, Update, Delete|date, identifier, department-organization, location, nursing-organization, patient, practitioner, service-provider|
|Invoice	|Read |identifier, account, subject|
|Location	|Read |identifier|
|Organization	|Read |identifier|
|Patient|Create, Read, Update, Delete|identifier, family, given, birthdate, organization|
|Practitioner	|Read |identifier|
|PractitionerRole	|Read |identifier|
|Procedure|Read |identifier, account|
|RelatedPerson|Create, Read, Update, Delete|identifier|
|Schedule	|Read |identifier, SAPexternalBookable, service-category, actor|
|Slot	|Read |SAPexternalBookable, schedule, service-category, start|