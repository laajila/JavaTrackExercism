class CustomUncheckedException extends RuntimeException {
    private RuntimeException customUnchecked;
    CustomUncheckedException() {
        this.customUnchecked= new RuntimeException("unchecked");
    }

    CustomUncheckedException(String message) {
        this.customUnchecked=new RuntimeException(message);
    }

}
