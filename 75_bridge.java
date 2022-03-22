class Bridge_pattern {
/*
Bridge is a structural design pattern that lets you split a large class 
or a set of closely related classes into two separate hierarchies — abstraction and implementation
— which can be developed independently of each other.
*/
    public static void main(String[] args) {

    }
    
    // View is an abstraction of article descriptions e.g. in catalogs
    // every View has a Resource
    static abstract class View {
        Resource resource;

        private View(){} //prevent empty instantiation

        // View is instantiated with a Resource
        public View(Resource resource){
            this.resource = resource;
        }
        public abstract String buildHTML();
    }

    // the following LongView and ShortView differs in
    // calling getLongText vs. getSnippet
    // and the composition of the View (which is not coded here for simplicity)
    static class LongView extends View {
        public String buildHTML(){
            String html = resource.getTitle()
                        + resource.getLongText()
                        + resource.getImage()
                        + resource.getLink();
            return html;
        }
    }

    static class ShortView extends View {
        public String buildHTML(){
            String html = resource.getTitle()
                        + resource.getSnippet()
                        + resource.getImage()
                        + resource.getLink();
            return html;
        }
    }

    // standardized way to describe things to be able to build a View about them
    interface Resource {
        public String getTitle();
        public String getLongText();
        public String getSnippet();
        public String getImage();
        public String getLink();
    }

    // the AbcResource class converts the Abc class responses into Resource format
    static class ArtistResource implements Resource{
        Artist artist;
        public ArtistResource(){}
        public ArtistResource(Artist artist){
            this.artist = artist;
        }
        public String getTitle(){
            return this.artist.getName();
        }
        public String getLongText(){
            return this.artist.getBio();
        }
        public String getSnippet(){
            return this.artist.getShortBio();
        }
        public String getImage(){
            return this.artist.getPortrait();
        }
        public String getLink(){
            return artist.getHomepageURL();
        }
    }

    static class Artist {
        // no attributes or methods are coded for simplicity
        public String getName() { return "";}
        public String getBio() { return "";}
        public String getShortBio() { return "";}
        public String getPortrait() { return "";}
        public String getHomepageURL() { return "";}
    }

    static class AlbumResource implements Resource{
        Album album;
        public AlbumResource(){}
        public AlbumResource(Album album){
            this.album = album;
        }
        public String getTitle(){
            return this.album.getTitle();
        }
        public String getLongText(){
            return this.album.getDescription();
        }
        public String getSnippet(){
            return this.album.getSongList();
        }
        public String getImage(){
            return this.album.getCover();
        }
        public String getLink(){
            return album.getStudioURL();
        }
    }

    static class Album {
        // no attributes or methods are coded for simplicity
        public String getTitle() { return "";}
        public String getDescription() { return "";}
        public String getSongList() { return "";}
        public String getCover() { return "";}
        public String getStudioURL() { return "";}
        // ... other methods
    }    
}