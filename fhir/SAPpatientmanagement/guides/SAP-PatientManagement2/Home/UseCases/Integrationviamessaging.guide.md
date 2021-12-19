### Integration via messaging
Messaging is a means of coupling applications in a loosely manner, similar to what is known from HL7 v2 messaging.

#### FHIR Messaging
[FHIR messaging](https://www.hl7.org/fhir/messaging.html) is not yet specified in the same way as [RESTful interactions](https://www.hl7.org/fhir/exchange-module.html#rest) are, especially the definition of events (i.e. the CodeSystem of message-events) and the definition of the message content (i.e. pre-defined [messageDefinition](https://www.hl7.org/fhir/messagedefinition.html)) are not detailed out. 
This leaves a certain degree of freedom to the application developers implementing FHIR messaging and results in less plug-and-play interoperability than in the RESTful interaction part of the FHIR specification. 

However, certain aspects are specified by the FHIR standard:
- The message being sent from a source application to a destination application is a Bundle of type “message”.  Several resources are bundled in this message, the first is the MessageHeader, the others are business resources and depend on the type of message.  
    - In the MessageHeader the event of the message is specified (in messageHeader.event). The associated valueSet is an example binding in FHIR R4.
    - The MessageDefinition resource specifies which other resources are communicated as part of the message. 

#### SAP implementation of FHIR Messaging
For the implementation of FHIR messaging, SAP followed the following approach:
- As the [messageDefinition](https://www.hl7.org/fhir/messagedefinition.html) for the message events is not yet predefined by the FHIR specification, SAP designed an event pattern based on the basic operations occurring on the business related FHIR resources. This means that per resource like Patient, Encounter etc. we defined messages like patient-created, encounter-updated or appointment-cancelled (see codeSystem [here](https://simplifier.net/fhirapiofsappatientmanagementis-h/message-events))
- Initial load is a particular event. Its purpose is to synchronize master data like practitioner with another system. The message with the event practioner-initialload sends all practitioner instances within SAP Patient Management as message. 
- The [messageDefinition](https://www.hl7.org/fhir/valueset-message-events.html) defines the content of the message per resource and event and also the expected response. The MessageDefinition resources per event can be found in the capabilityStatement of SAP Patient Management. Please note that these messageDefinition's are configurable. For more details, please see the **Configuration guide** and the **Developer guide**.
- Every time an event occurs a message is created. This message is sent by invoking the <code>$process-message</code> operation at the receiver.

#### Message example
Take an example of a message that is sent out every time a new procedure is created. On the picture below you can see an instance of this message and its definition. 
{{render:FHIRAPIofSAPPatientManagementIS-H/messagebundle}} 

**Message Definition**  
- The [messageDefinition](https://www.hl7.org/fhir/valueset-message-events.html) describes the structure of the message that is sent out containing in <code>.focus </code> these three resources 
    - the procedure that has been created
    - the patient for whom this procedure was performed
    - the encounter during which the procedure was performed. 
- In the <code>.event</code> element the event *procedure-created* is specified.

**Actual Message**
- As indicated in the FHIR standard, the actual message is a bundle of type "message" covering the messageHeader resource in which the event is specified (procedure-created). 
- The other resources referenced via the focus element are the resources that are specified in the corresponding messageDefinition.

#### Supported FHIR messages
These are the different messages that SAP Patient Management current supports: 

    - for inbound messaging (i.e. SAP Patient Management being the destination of the message) and 
    - for outbound messaging (i.e. SAP Patient Management being the sender of the message)

The table below lists all available messages:

|Resource|Messaging Inbound|Messaging Outbound|
|-
|Account|updated, cancelled|created, updated, cancelled|
|Appointment|created, updated, cancelled|created, Updated, cancelled|
|ChargeItem	| |created, updated, cancelled|
|Condition|created, updated, cancelled||
|Coverage|created, updated, cancelled|created, updated, cancelled|
|Encounter|created, updated, cancelled|created, updated, cancelled|
|Patient|created, updated, cancelled|created, updated, cancelled|
|Procedure| |created, updated, cancelled|
|RelatedPerson|created, updated, cancelled|created, updated, cancelled|

The corresponding events have the syntax: resource-operation. These events can be seen in the capabilityStatement.

For the following master data resources, the following outbound messages for initial load are supported:


|Resource|Ressources contained in the message|Message Definition|
|-
|Patient|Patient, Coverage, relatedPerson, appointment (open ones, i.e. with no corresponding encounter)|[patient-initial-load](https://simplifier.net/fhirapiofsappatientmanagementis-h/messagedefinition-example-duplicate-4)|
|Location|Location *(Building units within an institution that have an assignment to an organizational unit are returned as Location instances. The element Location.partOf contains the building unit the returned one belongs to hierarchically. The element location.managingOrganization contains the organizational unit the building units is assigned to.)*|[location-initial-load](https://simplifier.net/fhirapiofsappatientmanagementis-h/messagedefinition-example-duplicate-2)|
|Organization	|Organization | [organization-initial-load](https://simplifier.net/fhirapiofsappatientmanagementis-h/messagedefinition-example-duplicate-3)|
|Practitioner|Practitioner, PractitionerRole |[practitioner-initial-load](https://simplifier.net/fhirapiofsappatientmanagementis-h/messagedefinition-example-duplicate-5)|
|Schedule|Schedule|[schedule-initial-load](https://simplifier.net/fhirapiofsappatientmanagementis-h/messagedefinition-example)|


All supported events can be seen by reading the MessageDefinition in the SAP Patient Management system with the operation: *GET http(s)://[host>:<port]/[FHIR-endpoint]/MessageDefinition/[message ID]*

Example: GET http(s)://[host>:<port]/[FHIR-endpoint]/MessageDefinition/location-initial-load-sender

If you want to get more insights on how a specific scenario is implemented based on FHIR messaging, have a look at the *Waiting Time Integration Guide*.



