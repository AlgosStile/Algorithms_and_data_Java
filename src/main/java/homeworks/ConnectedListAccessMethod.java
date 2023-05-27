package homeworks;

import java.util.Iterator;

public class ConnectedListAccessMethod {
    public static void main(String[] args) {
        SingleLinkList<Contact> contactList = new SingleLinkList<>();

        contactList.addToEnd(new Contact(111, "Виниаминов Игнатий Фёкловский", "+79663758586"));
        contactList.addToEnd(new Contact(112, "Виниаминов Федор Фёкловский", "+79663758588"));
        contactList.addToEnd(new Contact(113, "Виниаминов Амвросий Фёкловский", "+79663758587"));
        contactList.addToEnd(new Contact(114, "Виниаминов Глеб Фёкловский", "+79663758589"));
        contactList.addToEnd(new Contact(115, "Виниаминов Багратион Фёкловский", "+79663758590"));

        for (Object contact : contactList) {
            System.out.println(contact);
        }
        contactList.reverse();

        System.out.println("________________________*******_______________________");

        for (Object contact : contactList) {
            System.out.println(contact);
        }
    }

    static class Contact {

        int id;
        String name;
        String phone;

        public Contact(int id, String name, String phone) {
            this.id = id;
            this.name = name;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return "Contact{" + "id=" + id + ", name='" + name + '\'' + ", phone='" + phone + '\'' + '}';
        }
    }

    public static class SingleLinkList<T> implements Iterable {

        ListItem<T> head;
        ListItem<T> tail;

        @Override
        public Iterator iterator() {
            return new Iterator<T>() {
                ListItem<T> current = head;

                @Override
                public boolean hasNext() {
                    return current != null;
                }

                @Override
                public T next() {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
            };
        }

        private static class ListItem<T> {

            T data;
            ListItem<T> next;
        }

        //! проверка на пустоту
        public boolean isEmpty() {
            return head == null;
        }

        //*! заполнение списка
        public void addToEnd(T item) {

            //Выделяем память
            ListItem<T> newItem = new ListItem<>();
            newItem.data = item;


            if (isEmpty()) {
                head = newItem;
                tail = newItem;
            } else {
                tail.next = newItem;
                tail = newItem;
            }
        }

        //*! метод разворота списка
        public void reverse() {
            if (!isEmpty() && head.next != null) {
                tail = head;
                ListItem<T> current = head.next;
                head.next = null;
                while (current != null) {
                    ListItem<T> next = current.next;
                    current.next = head;
                    head = current;
                    current = next;
                }
            }
        }
    }
}

