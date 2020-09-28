package com.company;

import javax.management.Query;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        new PhoneBook().processQueries();
    }

    public static class PhoneBook {

        private FastScanner in = new FastScanner();
        // Keep list of all existing (i.e. not deleted yet) contacts.
        private List<Contact> contacts = new ArrayList<>();
        private HashSet<Contact> hashSet = new HashSet<>();
        private Hashtable<Integer,String> hashtable = new Hashtable<>();
        private int queryCount = in.nextInt();

        private Query readQuery() {
            String type = in.next();
            int number = in.nextInt();
            if (type.equals("add")) {
                String name = in.next();
                return new Query(type, name, number);
            } else {
                return new Query(type, number);
            }
        }

        private void writeResponse(String response) {
            System.out.println(response);
        }

        private String[] phBook = new String[10000000];
        private void processQuery(Query query) {
            if (query.type.equals("add")) {
                // if we already have contact with such number,
                // we should rewrite contact's name
                boolean wasFound = false;
                phBook[query.number] = query.name;

//                // using hash-table
//                if (hashtable.contains(query.number)) {
//                    wasFound = true;
//                }
//                if (!wasFound) {
//                    hashtable.put(query.number, query.name);
//                    //System.out.println("After insertion : " + hashtable.toString());
//                }

                // using hast-set
//                if (hashSet.contains(query.number)) {
//                    wasFound = true;
//                }
//                if (!wasFound) {
//                    hashSet.add(new Contact(query.name, query.number));
//                }

                // Naive algorithm
//                for (Contact contact : contacts)
//                    if (contact.number == query.number) {
//                        contact.name = query.name;
//                        wasFound = true;
//                        break;
//                    }
//                // otherwise, just add it
//                if (!wasFound)
//                    contacts.add(new Contact(query.name, query.number));
            }
            else if (query.type.equals("del")) {
                phBook[query.number] = null;
//                if (hashtable.containsKey(query.number)) {
//                    hashtable.remove(query.number);
//                    //System.out.println("After deletion : " + hashtable.toString());
//                }
//                for (Iterator<Contact> it = contacts.iterator(); it.hasNext(); )
//                    if (it.next().number == query.number) {
//                        it.remove();
//                        break;
//                    }
            }
            else {
                String response = "not found";
                if (phBook[query.number] != null) {
                    response = phBook[query.number];
                }
//                if (hashtable.containsKey(query.number)) {
//                    //int index = hashtable.get(query.name);
//                    response = hashtable.get(query.number);
//                }
//                for (Contact contact: contacts)
//                    if (contact.number == query.number) {
//                        response = contact.name;
//                        break;
//                    }
                writeResponse(response);
            }
        }

        public void processQueries() {
            for (int i = 0; i < queryCount; ++i)
                processQuery(readQuery());
        }


        static class Contact {
            String name;
            int number;

            public Contact(String name, int number) {
                this.name = name;
                this.number = number;
            }
        }

        static class Query {
            String type;
            String name;
            int number;

            public Query(String type, String name, int number) {
                this.type = type;
                this.name = name;
                this.number = number;
            }

            public Query(String type, int number) {
                this.type = type;
                this.number = number;
            }
        }

        static class FastScanner {
            BufferedReader br;
            StringTokenizer st;

            FastScanner() {
                br = new BufferedReader(new InputStreamReader(System.in));
            }

            String next() {
                while (st == null || !st.hasMoreTokens()) {
                    try {
                        st = new StringTokenizer(br.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return st.nextToken();
            }

            int nextInt() {
                return Integer.parseInt(next());
            }
        }
    }



}
