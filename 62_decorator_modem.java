class Decorator_Pattern_modem {
/*

*/    
    public static void main(String[] args) {
        Modem dlink = new RealModem();
        User me = new User(true);
        me.setupModem(dlink);
        me.requestModemToConnect();
        User you = new User(false);
        you.setupModem(dlink);
        you.requestModemToConnect();
    }

    interface Modem{
        public void dial();
        public void setSpeakerVolume(int volume);
    }

    static class RealModem implements Modem{
        private int speakerVolume;
        public void dial(){
            System.out.println("dialing ... speaker volume:"+speakerVolume);
        }
        public void setSpeakerVolume(int volume){
            this.speakerVolume = volume;
        }        
    }

    static abstract class SpeakerVolumePreSetModem implements Modem{
        Modem realModem;
        public void dial(){ 
            realModem.dial(); 
        }
        public void setSpeakerVolume(int volume){
            realModem.setSpeakerVolume(volume);            
        }
    }

    static class LoudModem extends SpeakerVolumePreSetModem{
        public LoudModem(Modem modem){
            realModem = modem;
            realModem.setSpeakerVolume(99);
        }
    }
    static class QuietModem extends SpeakerVolumePreSetModem{
        public QuietModem(Modem modem){
            realModem = modem;
            realModem.setSpeakerVolume(0);
        }
    }

    static class User{
        private boolean likesLoudModemSpeaker;
        private Modem myModem;
        public User(boolean likesLoudModemSpeaker){ 
            this.likesLoudModemSpeaker = likesLoudModemSpeaker;
        }
        public void setupModem(Modem modem){
            // setup modem according to user preference
            if (this.likesLoudModemSpeaker) myModem = new LoudModem(modem);
            else myModem = new QuietModem(modem);
        }
        public void requestModemToConnect(){
            myModem.dial();
        }
    }

}