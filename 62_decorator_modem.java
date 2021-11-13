class Decorator_Pattern_modem {
/*

*/    
    public static void main(String[] args) {
        Modem dlink = new RealModem();
        User me = new User(true);
        me.setupModem(dlink);
        User you = new User(false);
        you.setupModem(dlink);

        me.requestModemToConnect();
        you.requestModemToConnect();
        me.requestModemToConnect();
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
        int speakerVolumePreSet;
        public void dial(){
            realModem.setSpeakerVolume(this.speakerVolumePreSet);
            realModem.dial(); 
        }
        public void setSpeakerVolume(int volume){
            realModem.setSpeakerVolume(volume);            
        }
    }

    static class LoudModem extends SpeakerVolumePreSetModem{
        public LoudModem(Modem modem){
            realModem = modem;
            super.speakerVolumePreSet=99;
        }
    }
    static class QuietModem extends SpeakerVolumePreSetModem{
        public QuietModem(Modem modem){
            realModem = modem;
            super.speakerVolumePreSet=0;
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