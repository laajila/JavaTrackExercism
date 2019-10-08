class UnsolvablePuzzleException extends Exception {
    private Exception unsolvable;
    UnsolvablePuzzleException(String message){
        this.unsolvable=new Exception(message);
    }
}
