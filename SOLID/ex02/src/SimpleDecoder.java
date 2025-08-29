public class SimpleDecoder implements Decoder{

    @Override
    public Frame decoder(byte[] fileBytes) {
        return new Frame(fileBytes);
    }
    
}
