package ex05;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
    public void printMenu(boolean dev) {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transactions for a specific user");
        if(dev)System.out.println("5. DEV – remove a transfer by ID");
        if(dev)System.out.println("6. DEV – check transfer validity");
        System.out.println("7. Finish execution");
        Scanner scan = new Scanner(System.in);
        boolean flag = false;
        TransactionsService service = new TransactionsService();
        int idx = 8;
        while (true) {
                if (!flag) idx = scan.nextInt();
                flag = false;
            if (idx == 1) {
                System.out.println("Enter a user name and a balance");
                String name = scan.next();
                int balance = scan.nextInt();

                try {
                    User user = new User(name, balance);
                    service.addUser(user);
                    System.out.println("User with id = " + user.getIdentifier() + " id added");
                } catch (BadBalanceExeption e) {
                    System.out.println(e.getMessage());
                    flag = true;
                }

            } else if (idx == 2) {
                System.out.println("Enter a user ID");
                int id = scan.nextInt();
                try {
                    System.out.println(service.getUserName(id) + " - " + service.getUserBalance(id));
                } catch (UserNotFoundException e) {
                    System.out.println("User not found");
                    flag = true;
                }
            } else if (idx == 3) {
                System.out.println("Enter a sender ID, a recipient ID, and a transfer amount");
                int id_sender = scan.nextInt();
                int id_recipient = scan.nextInt();
                int tran_am = scan.nextInt();
                try {
                    service.performTransaction(id_recipient, id_sender, tran_am);
                    System.out.println("The transfer is completed");
                } catch (IllegalTransactionException e) {
                    System.out.println("The transfer is not completed Illegal Transaction");
                    flag = true;
                } catch (UserNotFoundException b) {
                    System.out.println("The transfer is not completed User not found");
                    flag = true;
                } catch (InvalidTransferAmountException e) {
                    e.getMessage();
                    flag = true;
                }

            } else if (idx == 4) {
                System.out.println("Enter a user ID");
                int id_user = scan.nextInt();
                try {
                    Transaction[] t = service.getTransfers(id_user);
                    for (Transaction elem : t) {
                        System.out.println("To " +  elem.getRecipient().getName() + "(id = " + elem.getRecipient().getIdentifier() + ") " + elem.getTransfer_amount() + " with id = " + elem.getIdentifier());
                    }
                } catch (UserNotFoundException e) {
                    System.out.println("User not found");
                    flag = true;
                }


            } else if( idx == 5 && dev) {
                System.out.println("Enter a user ID and a transfer ID");
                int id_user = scan.nextInt();
                String id_tran_string = scan.next();
                UUID id_tran = UUID.fromString(id_tran_string);
                try {
                    Transaction[] user_trans = service.getTransfers(id_user);

                    String name = "";
                    int id =0;
                    int tr_am = 0;
                    for (Transaction elem : user_trans) {
                        if (elem.getIdentifier().equals(id_tran) ) {
                          name = elem.getRecipient().getName();
                          id = elem.getRecipient().getIdentifier();
                          tr_am = elem.getTransfer_amount();
                        }
                    }
                    service.deleteUserTransaction(id_user, id_tran);
                    System.out.printf("Transfer To %s(id = %d) %d removed" , name, id,tr_am);
                    System.out.println();
                } catch (UserNotFoundException e) {
                    System.out.println("User not found");
                    flag = true;
                } catch (TransactionNotFoundException e) {
                    System.out.println("Transaction not found");
                    flag = true;
                }


            } else if(idx == 6 && dev) {
                System.out.println("Check results:");
                try {
                    Transaction[] not_paired_tran = service.arrayNotPairedTransactions();
                    for (Transaction elem : not_paired_tran) {
                        System.out.printf("%s(id = %d) has an unacknowledged transfer id = %s from %s(id = %d) for %d",elem.getRecipient().getName(),elem.getRecipient().getIdentifier(),elem.getIdentifier().toString(),elem.getSender().getName(), elem.getSender().getIdentifier(), elem.getTransfer_amount());
                    }
                } catch (UserNotFoundException e) {
                    System.out.println("User not found");
                    flag = true;
                }

            } else if (idx == 7) {
                break;
            }
        }
    }
}
