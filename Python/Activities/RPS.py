import random

choices = ["Rock", "Paper", "Scissors"]

while True:

    computer_choice = random.choice(choices)

    user_choice = input("Enter your choice (Rock, Paper, or Scissors): ")

    print("Player chose:", user_choice)
    print("Computer chose:", computer_choice)

    if user_choice.lower() not in ["rock", "paper", "scissors"]:
        print("Invalid input! Please enter Rock, Paper, or Scissors.")

    elif user_choice.lower() == computer_choice.lower():
        print("Result: It's a Tie!")

    elif (
        (user_choice.lower() == "rock" and computer_choice == "Scissors") or
        (user_choice.lower() == "paper" and computer_choice == "Rock") or
        (user_choice.lower() == "scissors" and computer_choice == "Paper")
    ):
        print("Result: Player Wins!")

    else:
        print("Result: Computer Wins!")

    play_again = input("Do you want to play again? (yes/no): ")

    if play_again.lower() != "yes":
        print("Thanks for playing!")
        break