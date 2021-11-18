class Decorator_Pattern_modem {
/*
There is a modem to dial up internet provider. It is used by you and me.
I like the sound of the dialing by the modem, you don't.
Let's use customized modems according to our preferences.
*/    
    public static void main(String[] args) {
        Modem dlink = ModemFactory.makeModem();
        UserPreferences preferences1 = new UserPreferences().loudDial(true);
        UserPreferences preferences2 = new UserPreferences().loudDial(false);

        User me = new User(preferences1);
        me.setModem(dlink);
        User you = new User(preferences2);
        you.setModem(dlink);

        me.requestModemToConnect(new PhoneNumber(123456));
        you.requestModemToConnect(new PhoneNumber(234567));
        me.requestModemToConnect(new PhoneNumber(345678));
    }

    interface Modem{
        public void dial(PhoneNumber number);
        public void setSpeakerVolume(int volume);
        // and other methods
    }

    static class RealModem implements Modem{
        private int speakerVolume;
        public void dial(PhoneNumber number){
            System.out.println("dialing "+number
                                +" ... speaker volume:"+speakerVolume);
        }
        public void setSpeakerVolume(int volume){
            this.speakerVolume = volume;
        }        
    }

    static abstract class SpeakerVolumePreSetModem implements Modem{
        Modem realModem;
        int speakerVolumePreSet;
        public SpeakerVolumePreSetModem(Modem realModem, int dialVolume){
            this.realModem = realModem;
            this.speakerVolumePreSet = dialVolume;
        }
        public void dial(PhoneNumber number){
            realModem.setSpeakerVolume(this.speakerVolumePreSet);
            realModem.dial(number); 
        }
        public void setSpeakerVolume(int volume){
            realModem.setSpeakerVolume(volume);            
        }
    }

    static class LoudDialModem extends SpeakerVolumePreSetModem{
        public LoudDialModem(Modem modem){
            super(modem, 99);
        }
    }
    static class QuietDialModem extends SpeakerVolumePreSetModem{
        public QuietDialModem(Modem modem){
            super(modem, 0);
        }
    }
    // user has a modem and preferences
    static class User{
        private UserPreferences myPreferences;
        private Modem myModem;
        public User(UserPreferences preferences){ 
            this.myPreferences = preferences;
        }
        public void setModem(Modem modem){
            // get modem customized with user preference
            myModem = ModemFactory.getCustomizedDialVolumeModem(
                       modem,
                       myPreferences.loudDial);
        }
        public void requestModemToConnect(PhoneNumber number){
            myModem.dial(number);
        }
    }
    // phone number to dial by a modem
    static class PhoneNumber{
       int number;
       public PhoneNumber(int number){
           this.number = number;
       }
       @Override
        public String toString() {
            return String.valueOf(number);
        }
    }
    // catalog of user preferences
    static class UserPreferences{
        boolean loudDial;
        public UserPreferences loudDial(boolean loudDial){
            this.loudDial = loudDial;
            return this;
        }
    }
    static class ModemFactory{
        static public Modem makeModem(){
            return new RealModem();
        }
        static public Modem getCustomizedDialVolumeModem(Modem modem, boolean loudDial){
            if (loudDial) return new LoudDialModem(modem);
            else return new QuietDialModem(modem);
        }
    }
}