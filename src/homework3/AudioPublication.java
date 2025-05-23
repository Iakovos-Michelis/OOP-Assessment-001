package homework3;

public class AudioPublication extends Publication {

    private int DurationMinutes;
    private String VoiceActor;

    // Create an audio version with extra details
    public AudioPublication(String id, String title, double cost, String author,
                            int durationMinutes, String voiceActor) {
        super(id, title, cost, author);
        this.DurationMinutes = durationMinutes;
        this.VoiceActor = voiceActor;
    }


    // Showing full details including audio info
    @Override
    public void showDetails() {
        super.showDetails();
        System.out.println("Format: Audio");
        System.out.println("Duration: " + DurationMinutes + " minutes");
        System.out.println("Narrated by: " + VoiceActor);
    }
}