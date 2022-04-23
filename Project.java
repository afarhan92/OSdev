class DNode

{

String contents;

DNode next;

DNode prev;

// Constructor: builds a node which can be searched forwards and backwards

DNode (String k)

{

next= null; prev= null;

contents= k;

}

// Constructor: builds a node with given references

DNode (String k, DNode prev, DNode next)

{

this.prev = prev;

this.next = next;

this.contents = k;

}

DNode searchForwards(DNode curr, String key)

{

while (curr != null)

{

if(curr.contents.compareTo(key) == 0)

{

return curr;

}

curr = curr.next;

}

return null;

}

DNode searchBackwards(DNode curr, String key)

{

while (curr != null)

{

if(curr.contents.compareTo(key) == 0)

{

return curr;

}

curr = curr.prev;

}

return null;

}

void insertAfter(DNode curr, DNode newNode)

{

//check if the given curr is NULL

if(curr == null)

{

return;

}   

// Make next of new newNode as next of curr

newNode.next = curr.next;

  

// Make the next of curr as newNode

curr.next = newNode;

// Make curr as previous of newNode

newNode.prev = curr;

// Change previous of newNode newNode node

if(newNode.next != null)

newNode.next.prev = newNode;

}

void insertBefore(DNode curr, DNode newNode)

{

//check if the given curr is NULL

if(curr == null)

{

return;

}  

  

// Make prev of new newNode as prev of curr

newNode.prev = curr.prev;

  

// Make next of new newNode as curr

newNode.next = curr;

  

// Make prev of curr as newNode

curr.prev = newNode;

// Change next of newNode newNode node

if(newNode.prev != null)

{

newNode.prev.next = newNode;

}

}

}

public class DLSList

{

DNode head; // The first node in the list

DNode lastVisited; // The address of the node last visited

int numNodes; // The number of nodes in the list

DLSList ()

{

head= null;

lastVisited= null;

numNodes= 0;

}

// Post: newNode is inserted into the current list in correct sorted order

// numNodes is adjusted to be equal to the number of nodes in the list

void addNewNode(DNode newNode)

{

DNode current;

// if list is empty

if (head == null)

head = newNode;

// if the node is to be inserted at the beginning

else if (head.contents.compareTo(newNode.contents) >= 0)

{

newNode.next = head;

newNode.next.prev = newNode;

head = newNode;

}

else

{

current = head;

// locate the node after which the new node

// is to be inserted

while (current.next != null && current.next.contents.compareTo(newNode.contents) < 0)

current = current.next;

/* Make the appropriate links */

newNode.next = current.next;

// if the new node is not inserted

// at the end of the list

if (current.next != null)

newNode.next.prev = newNode;

current.next = newNode;

newNode.prev = current;

}

numNodes++;

}

// Post: All occurrences of nodes with contents field equal to key are removed.

// If lastVisited points to one of the removed nodes, then lastVisited is set to head

// numNodes is adjusted to be equal to the number of nodes in the list

void removeNode(String key)

{

DNode current = head;

DNode previous = null;

while (current != null)

{

if (current.contents.compareTo(key) == 0)

{

if (current == head)

{

head = head.next;

current = head;

}

else

{

previous.next = current.next;

current = previous.next;

}

if(current == lastVisited)

{

lastVisited = head;

}

numNodes--;

}

else

{

previous = current;

current = current.next;

}

}

}

// Post: Returns the address of the first node (in ascending order) whose contents equal key, and null if there is no such node;

// lastVisited is set to the address returned if it is not null, otherwise lastVisited remains unchanged

DNode visit(String key)

{

DNode current = head; //Initialize current

while (current != null)

{

if (current.contents.compareTo(key) == 0) //If found

{

lastVisited = current;

return current;

}

current = current.next;

}

return null;

}

}