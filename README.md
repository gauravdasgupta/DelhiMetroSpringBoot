# DelhiMetroSpringBoot
A Sample project based on DMRC(Delhi Metro Railway Corporation) Use Case.  

Coding Exercise for Designing Smart Card System for Delhi Metro. 
implement ‘Metro Smart Card System’ (MSCS) for Delhi city. For application assume there is a single metro line covering 10 stations linearly. 
The stations name are A1, A2, A3, A4, A5, A6, A7, A8, A9, A10 as shown below. The travel can be in any direction.

Travelers have smart cards that behave just like any regular debit card that has an initial balance when purchased. Travelers swipe-in when they enter a metro station and swipe-out when they exit. The card balance is automatically updated at swipe-out.

Objective of the exercise is to create an automated system that has following functionalities:

2.1 Card should have a minimum balance of Rs 5.5 at swipe-in. At swipe-out, system should calculate the fare based on below strategies set at the start of the day. The fare must be deducted from the card. 
2.2 Card should have the sufficient balance otherwise user should NOT be able to exit. 
Weekday – Rs. 7 * (Number of stations traveled) 
Weekend – Rs. 5.5 * (Number of station traveled if it’s Saturday or Sunday) 
(* there can be more such fare strategies in future)
