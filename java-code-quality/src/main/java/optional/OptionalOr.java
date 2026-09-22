package optional;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Character.isDigit;
import static java.lang.Character.isLetter;
import static java.util.Objects.requireNonNull;

// TODO: 通过Optional.or()来执行"或"的逻辑
public class OptionalOr {

    public static void main(String[] args) {
        Optional<Customer> optional = load("OK");
        if (optional.isPresent()) {
            System.out.println(optional.get());
        }
    }

    // Chain the `from` methods and return the first non-empty Optional (if one exists)
    public static Optional<Customer> load(String id) {
        return fromMemory(id)
                .or(() -> fromDisk(id))
                .or(() -> fromRemote(id));
    }

    public static Optional<Customer> fromMemory(String id) {
        System.out.println("From memory");
        return isDigit(id.charAt(0))
                ? Optional.of(new Customer(id))
                : Optional.empty();
    }

    public static Optional<Customer> fromDisk(String id) {
        System.out.println("From Disk");
        return isLetter(id.charAt(0))
                ? Optional.of(new Customer(id))
                : Optional.empty();
    }

    public static Optional<Customer> fromRemote(String id) {
        System.out.println("From Remote");
        return ThreadLocalRandom.current().nextBoolean()
                ? Optional.of(new Customer(id))
                : Optional.empty();
    }

    static class Customer {

        final String id;

        Customer(String id) {
            this.id = requireNonNull(id);
        }

        @Override
        public String toString() {
            return "Customer (" + id + ")";
        }

    }
}
