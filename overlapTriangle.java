public class Solution {
    
    // Overlap Rectangle
    // Rect 1: top-left(A, B), bottom-right(C, D)
    // Rect 2: top-left(E, F), bottom-right(G, H)
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int innerL = Math.max(A, E);
        int innerR = Math.max(innerL, Math.min(C, G));
        int innerT = Math.min(B, F);
        int innerB = Math.min(innerT, Math.max(D, H));
        return (innerR - innerL) * (innerT - innerB);
        
    }
}
