package array.meetGame;

public class MeetGame {
    public static class Player {
        private int id;
        private int totalMeeting;

        Player(int id) {
            this.id = id;
            this.totalMeeting = 0;
        }

        public int getId() {
            return this.id;
        }

        public int getTotalMeeting() {
            return this.totalMeeting;
        }

        public void incrementTotalMeeting() {
            this.totalMeeting++;
        }
    }

    public boolean meet(Player pl1, Player pl2) {
        if (pl1.getId() == pl2.getId()) {
            return false;
        }
        pl1.incrementTotalMeeting();
        return true;
    }

    public Player exposeWinner(Player[] players) {
        Player winner = players[0];
        for (int i = 1; i <= players.length; i++) {
            if (players[i].getTotalMeeting() > winner.getTotalMeeting()) {
                winner = players[i];
            }
        }
        return winner;
    }
}
