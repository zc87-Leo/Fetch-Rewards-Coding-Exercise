# Mails Processing System

**It is a web service that accepts http requests and returns responses. **

***For a detailed tutorial on how to run this project, please check the "user_doc.pdf" in the folder, thank you!***

## Main Function
Accept a list of email addresses and return an integer indicating the number of unique email addresses.

Unique email addresses means they will be delivered to the same account using Gmail account matching. Specifically: Gmail will ignore the placement of "." in the username. And it will ignore any portion of the username after a "+".

### Examples
test.email@gmail.com, test.email+spam@gmail.com and testemail@gmail.com will all go to the same address, and thus the result should be 1.
test.email@gmail.com and test.email@fetchrewards.com are two different email addresses, and thus the result should be 2.

### Test Results
**Request Body 1:**
{
  "emails_list":["test.email@gmail.com","test.email@fetchrewards.com"]
},
**Response Body 1:**
{
    "number_of_unique_emails": 2
}.

**Request Body 2:**
{
"emails_list":["test.email@gmail.com","test.email+spam@gmail.com","testemail@gmail.com"]
},

**Response Body 2:**
{
    "number_of_unique_emails": 1
}.

**Thanks for reading, have a nice day 😊！**


