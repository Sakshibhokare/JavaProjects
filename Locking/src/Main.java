import com.example.BankAccount;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
     BankAccount bankAccount = new BankAccount();
     //Runnable is a Interface so we created ananomus class
     Runnable task = new Runnable() {
          @Override
          public void run() {
               bankAccount.withdraw(50);
          }
     };
     Thread t1 = new Thread(task,"thread 1");
     Thread t2 = new Thread(task, "thread 2");
     t1.start();
     t2.start();
}
