## Project Description

**BussyDex** is a tracker app for the CTP Bus lines. Inspired by hobbies like bird watching, it lets the user track all the bus lines that they spotted, as well as provide some information about their routes. 
The app has 2 operation modes:
- User mode    -> The user can see a list of bus lines and mark them as spotted.
- Admin mode -> The user can add or remove bus lines
The user can switch between these modes by using the FAB.
The user can mark a bus as spotted/not spotted by entering User mode and tapping on the checkbox corresponding to said bus' card.
The user can add a bus line by entering Admin mode then tapping on the FAB that pops up, marked with a "+".
The user can delete a bus line by entering Admin mode then tapping on the red trash icon that appears in place of the checkbox/
When the user taps on a card, the card expands, revealing extra information about a given bus line.

## Domain Details

The app manages a single entity:
### Bus
- Name (String, displayed at the top of the cards)
- Description (String, displayed in the body of the cards, typically contains the route)
- Spotted (Boolean, represented by the checkbox in the right side of the cards)
- Date Added (String, displayed as extra information when a card is expanded)
- Date Spotted (String, displayed as extra information when a card is expanded)

## CRUD

**READ**: The app reads all added buses and their information from the database or from local storage in the case of offline use.
**CREATE**: In Admin mode, tapping on the FAB marked with a "+" will open a dialog box asking the user to input a Name and Description. Completing these fields and tapping on the Add button at the bottom of the dialog box will create a new Bus object and add it to the list of available buses. This bus will be initialized as not spotted, the Date Added field will be completed with the current date, and Date Spotted will be initialized as 0 in Unix Time (01-01-1970).
**UPDATE**: In User mode, tapping on a card's checkbox will update the corresponding bus object's Spotted field.
**DELETE**: In Admin mode, tapping a card's red trash button will delete the corresponding bus object from the list.

## Persistence

Creating a new bus object, updating one or deleting one will be persisted on the server and local database.

## Offline Use

If the device lacks network connectivity, there are multiple systems in place to allow the user to keep using the app.

On a first load, the app will try to connect to the server and retrieve the user's list from the database. If unable, the app will look into the device's local storage for the latest saved copy of the list. If nothing is found, a default list will be initialized.

When the user adds a bus, it will get added to the local storage list, and this operation will be saved in a log.

When the user spots or deletes a bus, these changes will be reflected in the local storage list, and these operations will be saved in a log.

When the device goes back online, the app will check the operation log. If not empty, every operation will get executed consecutively on the server, in order to sync the local list to the remote server.  

## Screenshots:
![Pasted image 20231029165321](https://github.com/trueNebula/bussydex/assets/68183013/7de47ab4-d561-4847-8dc3-19ba4dc25d74)
![Pasted image 20231029165345](https://github.com/trueNebula/bussydex/assets/68183013/4ae0e73b-6ffd-4a9d-a21b-8b2da4a1bc14)
