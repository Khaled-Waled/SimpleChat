# **What to do:**

- [ ] Do some testing for the message storing system
- [ ] ```User.getIdsByName``` ==> Get users provided their name (names are not unique)
- [ ] ```User.getUserById```  ==> Get a user provided their id
- [ ] ```User.toString```     ==> Return user data as a string
- [ ] Improve how messages are stored
- [ ] Add documentation
- [ ] Import Spring lib
- [ ] Create the REST API
- [ ] Encrypt messages




# **What was done:**

* Create User class and set attributes
* Create constructor and Getters & Setters for user class
* Establish database connection (MYSQL)
* User.getUserFromTuple ==> Translate User tuple to object
* Create basic hashing utility
* ```User.registerInDB``` ==> Register a user in the database
* Design how messages are stored
* ```MessageManager.retrieveConversation``` ==> Retrieve A conversation given two IDs