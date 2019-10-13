import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

class BankAccount {
    AtomicInteger balance;
    AtomicBoolean open;

    void open() {
        this.balance = new AtomicInteger(0);
        this.open = new AtomicBoolean(true);
    }

    int getBalance() throws BankAccountActionInvalidException {
        if (open.get()) {
            return this.balance.get();
        } else {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    void deposit(int money) throws BankAccountActionInvalidException {
        if (open.get()) {
            if (money < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            this.balance.getAndAdd(money);
        } else {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    void withdraw(int money) throws BankAccountActionInvalidException {
        if (open.get()) {
            if (money < 0) throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
            if (this.balance.get() == 0)
                throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
            if (money > this.balance.get())
                throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");

            this.balance.getAndAdd(-money);
        } else {
            throw new BankAccountActionInvalidException("Account closed");
        }
    }

    void close() {
        this.open.set(false);
    }
}