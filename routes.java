package com.niit;
public class routes {
        String source;
        String destination;
        int distancekm;
        String time;
        String ticketcost;

        public routes(String source, String destination, int distancekm, String time, String ticketcost) {
            this.source = source;
            this.destination = destination;
            this.distancekm = distancekm;
            this.time = time;
            this.ticketcost = ticketcost;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getDestination() {
            return destination;
        }

        public void setDestination(String destination) {
            this.destination = destination;
        }

        public int getDistancekm() {
            return distancekm;
        }

        public void setDistancekm(int distancekm) {
            this.distancekm = distancekm;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getTicketcost() {
            return ticketcost;
        }

        public void setTicketcost(String ticketcost) {
            this.ticketcost = ticketcost;
        }

        @Override
        public String toString() {
            return "airplane{" + "source='" + source + '\'' + ", destination='" + destination + '\'' + ", distancekm=" + distancekm +
                    ", time='" + time + '\'' + ", ticketcost=" + ticketcost + '}';
        }
    }


