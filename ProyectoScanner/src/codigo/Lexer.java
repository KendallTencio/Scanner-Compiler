/* The following code was generated by JFlex 1.4.3 on 24/05/20 11:40 AM */

package codigo;
import static codigo.Tokens.*;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 24/05/20 11:40 AM from the specification file
 * <tt>C:/Users/Franc/Documents/Uned Tec/tecDigital/2020 Semestre I/Compi/ProyectoScannerCompiladores/ProyectoScanner/src/codigo/Lexer.flex</tt>
 */
class Lexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\11\1\16\2\0\1\11\22\0\1\11\1\62\1\14\2\0"+
    "\1\65\1\64\1\15\1\17\1\17\1\61\1\10\1\11\1\5\1\6"+
    "\1\60\1\54\1\47\1\51\1\53\1\52\1\55\1\50\1\56\1\46"+
    "\1\2\1\65\1\65\1\66\1\63\1\67\1\65\1\0\4\4\1\7"+
    "\1\4\11\1\1\43\12\1\1\65\1\21\1\65\1\65\1\1\1\0"+
    "\1\24\1\27\1\34\1\25\1\3\1\40\1\42\1\12\1\36\1\1"+
    "\1\32\1\31\1\37\1\22\1\30\1\41\1\1\1\20\1\26\1\23"+
    "\1\35\1\44\1\45\1\13\1\33\1\57\1\65\1\65\1\65\1\65"+
    "\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\2\3\4\1\5\1\2"+
    "\2\1\1\6\1\4\20\2\5\4\2\7\1\3\3\2"+
    "\1\3\1\0\1\3\2\2\1\0\1\3\2\0\1\3"+
    "\1\0\4\2\1\10\40\2\1\5\1\0\1\3\1\0"+
    "\1\3\3\2\2\0\1\10\24\2\1\10\14\2\1\11"+
    "\1\2\1\0\1\3\1\0\1\2\3\0\4\2\1\12"+
    "\7\2\1\10\1\12\2\2\1\10\3\2\1\10\17\2"+
    "\1\5\2\0\11\2\1\10\15\2\2\0\1\10\4\2"+
    "\2\10\6\2\2\0\4\2\2\0\1\2\2\0\1\2"+
    "\6\0\1\3";

  private static int [] zzUnpackAction() {
    int [] result = new int[238];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\70\0\160\0\250\0\340\0\u0118\0\u0150\0\u0188"+
    "\0\u01c0\0\u01f8\0\u0230\0\u0268\0\70\0\70\0\u02a0\0\u02d8"+
    "\0\u0310\0\u0348\0\u0380\0\u03b8\0\u03f0\0\u0428\0\u0460\0\u0498"+
    "\0\u04d0\0\u0508\0\u0540\0\u0578\0\u05b0\0\u05e8\0\u0620\0\u0658"+
    "\0\u0690\0\u06c8\0\u0700\0\u0738\0\u0770\0\u07a8\0\u07e0\0\u0818"+
    "\0\u0850\0\u0888\0\u0150\0\u08c0\0\u08f8\0\u0930\0\u0230\0\u0230"+
    "\0\u0968\0\u0268\0\u0268\0\u09a0\0\u09d8\0\u0a10\0\u0a48\0\u0a80"+
    "\0\160\0\u0ab8\0\u0af0\0\u0b28\0\u0b60\0\u0b98\0\u0bd0\0\u0c08"+
    "\0\u0c40\0\u0c78\0\u0cb0\0\u0ce8\0\u0d20\0\u0d58\0\u0d90\0\u0dc8"+
    "\0\u0e00\0\u0e38\0\u0e70\0\u0ea8\0\u0ee0\0\u0f18\0\u0f50\0\u0f88"+
    "\0\u0fc0\0\u0ff8\0\u1030\0\u1068\0\u10a0\0\u10d8\0\u1110\0\u1148"+
    "\0\u1180\0\u11b8\0\u11f0\0\u1228\0\u1260\0\u1298\0\u12d0\0\u1308"+
    "\0\u1340\0\u1378\0\u13b0\0\u13e8\0\u1420\0\u1458\0\u1490\0\u14c8"+
    "\0\u1500\0\u1538\0\u1570\0\u15a8\0\u15e0\0\u1618\0\u1650\0\u1688"+
    "\0\u16c0\0\u16f8\0\u1730\0\u1768\0\u17a0\0\u17d8\0\u1810\0\u1848"+
    "\0\u1880\0\u18b8\0\u18f0\0\u1928\0\u1960\0\u1998\0\u19d0\0\u1a08"+
    "\0\u1a40\0\u1a78\0\u1ab0\0\u1ae8\0\u1b20\0\160\0\u1b58\0\u1b90"+
    "\0\u1260\0\u1bc8\0\u1c00\0\u1c38\0\u1c70\0\u1ca8\0\u1ce0\0\u1d18"+
    "\0\u1d50\0\u1d88\0\160\0\u1dc0\0\u1df8\0\u1e30\0\u1e68\0\u1ea0"+
    "\0\u1ed8\0\u1f10\0\u1f48\0\u1f80\0\u1fb8\0\u1ff0\0\u2028\0\u2060"+
    "\0\u2098\0\u20d0\0\u2108\0\u2140\0\u2178\0\u21b0\0\u2108\0\u21e8"+
    "\0\u2220\0\u2258\0\u2290\0\u22c8\0\u2300\0\u2338\0\u2370\0\u23a8"+
    "\0\u23e0\0\u2418\0\70\0\u2450\0\u2488\0\u24c0\0\u24f8\0\u2530"+
    "\0\u2568\0\u25a0\0\u25d8\0\u2610\0\u2648\0\u2680\0\u26b8\0\u26f0"+
    "\0\u2728\0\u2760\0\u2798\0\u27d0\0\u2808\0\u2840\0\u2878\0\u28b0"+
    "\0\u28e8\0\u2920\0\u2958\0\u2990\0\u29c8\0\u2a00\0\u1490\0\u2a38"+
    "\0\u2a70\0\u2aa8\0\u2ae0\0\u2b18\0\u2b50\0\u2b88\0\u2bc0\0\u2bf8"+
    "\0\u2c30\0\u2c68\0\u2ca0\0\u2cd8\0\u2d10\0\u2d48\0\u2d80\0\u2db8"+
    "\0\u2df0\0\u2e28\0\u2e60\0\u2e98\0\u2ed0\0\u2f08\0\u2f40\0\u2f78"+
    "\0\u2fb0\0\u2fe8\0\u3020\0\u3058\0\u3090\0\70";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[238];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\3\1\6\1\7\1\3"+
    "\1\10\1\11\1\12\1\3\1\13\1\14\1\15\1\16"+
    "\1\17\1\2\1\3\1\20\1\21\1\22\1\23\1\24"+
    "\3\3\1\25\1\26\1\27\1\30\1\31\1\32\1\33"+
    "\1\3\1\34\1\35\1\36\11\4\1\3\1\37\1\40"+
    "\2\10\1\41\1\16\1\42\1\43\71\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\36\3\10\0"+
    "\2\44\1\4\1\45\1\44\1\0\1\46\1\44\2\0"+
    "\4\44\2\0\26\44\11\4\1\44\11\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\1\47\1\50"+
    "\5\3\1\51\26\3\12\0\1\52\3\0\1\53\37\0"+
    "\11\52\4\0\1\16\6\0\1\54\43\0\11\54\74\0"+
    "\1\16\15\0\1\11\57\0\2\3\1\55\1\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\6\3\1\56"+
    "\27\3\10\0\14\57\1\60\1\57\3\0\1\61\2\0"+
    "\44\57\15\62\1\63\3\0\1\64\2\0\44\62\1\0"+
    "\2\3\1\65\1\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\36\3\11\0\4\3\2\0\1\3\2\0"+
    "\1\66\1\3\4\0\1\67\1\0\36\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\3\3"+
    "\1\70\1\71\31\3\11\0\2\3\1\72\1\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\2\3\1\73"+
    "\3\3\1\71\27\3\11\0\2\3\1\74\1\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\1\3\1\75"+
    "\4\3\1\76\26\3\1\77\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\100\1\0\2\3\1\101\3\3"+
    "\1\102\2\3\1\103\24\3\11\0\2\3\1\104\1\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\36\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\2\3\1\105\3\3\1\106\27\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\14\3"+
    "\1\107\1\3\1\110\17\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\1\111\14\3\1\112"+
    "\1\71\17\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\2\3\1\113\3\3\1\114\5\3"+
    "\1\115\21\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\116\1\0\2\3\1\117\3\3\1\120\4\3"+
    "\1\121\1\122\21\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\123\1\0\2\3\1\124\10\3\1\125"+
    "\22\3\11\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\126\1\0\36\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\2\3\1\120\11\3\1\127"+
    "\21\3\11\0\2\3\1\130\1\3\2\0\1\3\2\0"+
    "\1\131\1\3\4\0\1\3\1\0\36\3\70\0\1\132"+
    "\1\133\1\0\1\16\65\0\1\16\1\0\1\16\70\0"+
    "\1\16\66\0\1\16\2\0\1\16\64\0\1\16\3\0"+
    "\1\16\5\44\2\0\1\44\2\0\4\44\2\0\40\44"+
    "\10\0\2\44\1\134\2\44\1\135\1\0\1\44\2\0"+
    "\4\44\2\0\26\44\11\134\1\44\12\0\1\136\43\0"+
    "\11\136\12\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\13\3\1\137\22\3\11\0\4\3\2\0"+
    "\1\3\2\0\1\140\1\3\4\0\1\3\1\0\36\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\4\3\1\141\31\3\12\0\1\52\1\142\2\0"+
    "\1\46\37\0\11\52\13\0\1\54\1\143\3\0\1\143"+
    "\36\0\11\54\12\0\4\3\2\0\1\3\2\0\1\3"+
    "\1\144\4\0\1\3\1\0\36\3\11\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\13\3\1\145"+
    "\22\3\30\0\1\57\1\0\2\57\64\0\1\62\1\0"+
    "\2\62\45\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\1\3\1\146\34\3\11\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\14\3\1\147"+
    "\21\3\11\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\2\3\1\150\10\3\1\141\22\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\3\3\1\151\32\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\7\3\1\152\26\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\11\3\1\153\24\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\1\154\11\3\1\155\23\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\156"+
    "\1\0\36\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\7\3\1\157\26\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\2\3"+
    "\1\160\33\3\11\0\2\3\1\161\1\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\36\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\7\3"+
    "\1\162\26\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\6\3\1\163\27\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\1\3"+
    "\1\164\34\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\2\3\1\145\33\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\7\3"+
    "\1\165\26\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\1\166\35\3\11\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\1\167\35\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\14\3\1\170\21\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\1\3\1\171\34\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\17\3\1\172\16\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\17\3\1\173\16\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\3\3\1\174\32\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\1\175\35\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\6\3\1\137\27\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\7\3\1\51\26\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\71\1\0"+
    "\36\3\11\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\1\176\35\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\1\177\35\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\14\3\1\200\21\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\11\3\1\201\24\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\5\3\1\202\30\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\2\3\1\203\33\3\11\0"+
    "\2\3\1\204\1\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\36\3\11\0\2\3\1\205\1\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\14\3\1\206"+
    "\21\3\11\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\14\3\1\207\21\3\10\0\16\132\1\0"+
    "\51\132\61\133\1\210\6\133\2\44\1\134\2\44\2\0"+
    "\1\44\2\0\4\44\2\0\26\44\11\134\1\44\12\0"+
    "\1\211\43\0\11\211\13\0\1\136\1\212\3\0\1\212"+
    "\36\0\11\136\12\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\15\3\1\71\20\3\11\0\2\3"+
    "\1\213\1\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\36\3\11\0\2\3\1\71\1\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\36\3\12\0\1\211"+
    "\2\0\1\135\40\0\11\211\13\0\1\46\2\0\1\214"+
    "\2\0\1\214\35\0\11\46\12\0\4\3\2\0\1\3"+
    "\2\0\2\3\1\215\1\216\2\0\1\3\1\0\36\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\153"+
    "\1\0\36\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\13\3\1\217\22\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\4\3"+
    "\1\71\31\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\1\220\35\3\11\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\221\1\0\36\3\11\0"+
    "\2\3\1\222\1\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\36\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\4\3\1\206\31\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\3\3\1\223\32\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\6\3\1\224\27\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\13\3\1\225\1\226\21\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\14\3\1\227\21\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\5\3\1\230\30\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\2\3\1\231\33\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\2\3\1\232\33\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\7\3\1\71\26\3"+
    "\11\0\2\3\1\233\1\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\36\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\7\3\1\234\26\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\1\3\1\235\2\3\1\236\31\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\1\3"+
    "\1\237\34\3\11\0\4\3\2\0\1\3\2\0\1\3"+
    "\1\240\4\0\1\3\1\0\36\3\11\0\1\3\1\241"+
    "\1\242\1\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\24\3\1\243\1\244\1\245\1\246\1\247\1\250"+
    "\1\3\1\241\1\250\1\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\6\3\1\251\27\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\17\3\1\252\16\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\14\3\1\253\21\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\13\3\1\254\22\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\12\3\1\255\23\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\1\256\35\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\22\3\1\257\13\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\2\3\1\260\33\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\7\3\1\261\26\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\20\3\1\262\15\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\23\3\1\71\12\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\10\3\1\153\25\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\7\3\1\141\26\3\10\0"+
    "\60\133\1\263\1\210\6\133\2\0\1\211\2\0\1\135"+
    "\2\0\1\135\35\0\11\211\12\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\206\1\0\36\3\12\0\1\46"+
    "\43\0\11\46\13\0\3\264\2\0\1\264\14\0\2\264"+
    "\1\0\1\264\4\0\1\264\3\0\1\264\5\0\11\264"+
    "\13\0\3\265\2\0\1\265\14\0\2\265\1\0\1\265"+
    "\4\0\1\265\3\0\1\265\5\0\11\265\12\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\266\1\0\36\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\4\3\1\267\31\3\11\0\2\3\1\270\1\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\36\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\1\3\1\141\16\3\1\271\15\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\1\272"+
    "\35\3\11\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\12\3\1\273\23\3\11\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\1\274\35\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\3\3\1\275\32\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\6\3\1\206\27\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\10\3\1\71\25\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\1\276\35\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\4\3\1\277\31\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\12\3\1\300\23\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\301\1\0"+
    "\14\3\1\302\21\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\1\3\1\303\34\3\11\0"+
    "\1\3\1\241\2\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\24\3\1\243\1\244\1\245\1\246\1\247"+
    "\1\250\1\3\1\241\1\250\1\3\11\0\2\3\1\304"+
    "\1\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\36\3\11\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\26\3\1\71\7\3\11\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\305\1\0\36\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\24\3\1\71\5\3\1\71\3\3\11\0\1\3\1\250"+
    "\2\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\24\3\1\245\1\250\1\243\1\247\1\245\1\241\1\245"+
    "\1\250\1\241\1\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\30\3\1\71\5\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\25\3\1\241\1\3\1\245\1\243\1\250\1\247\1\241"+
    "\2\3\11\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\27\3\1\71\6\3\11\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\273\1\0\36\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\14\3\1\226\21\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\16\3\1\306\17\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\1\3\1\307\34\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\1\3\1\310\34\3\11\0"+
    "\2\3\1\311\1\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\36\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\2\3\1\312\33\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\5\3\1\207\30\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\14\3\1\313\21\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\15\3\1\314\20\3\12\0\3\315\2\0\1\315\14\0"+
    "\2\315\1\0\1\315\4\0\1\315\3\0\1\315\5\0"+
    "\11\315\13\0\3\316\2\0\1\316\14\0\2\316\1\0"+
    "\1\316\4\0\1\316\3\0\1\316\5\0\11\316\12\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\1\317\35\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\16\3\1\320\17\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\4\3"+
    "\1\147\31\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\2\3\1\321\33\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\3\3"+
    "\1\153\32\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\1\3\1\71\34\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\20\3"+
    "\1\71\15\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\3\1\0\14\3\1\322\21\3\11\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\12\3"+
    "\1\323\23\3\11\0\1\3\1\71\2\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\24\3\1\71\1\324"+
    "\1\71\1\324\1\71\1\325\1\3\2\71\1\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\6\3\1\326\27\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\2\3\1\225\33\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\1\327\35\3\11\0\4\3\2\0\1\3\2\0\2\3"+
    "\4\0\1\330\1\0\36\3\11\0\4\3\2\0\1\3"+
    "\2\0\2\3\4\0\1\3\1\0\3\3\1\71\32\3"+
    "\11\0\4\3\2\0\1\3\2\0\2\3\4\0\1\3"+
    "\1\0\1\331\35\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\14\3\1\332\21\3\11\0"+
    "\2\3\1\153\1\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\36\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\14\3\1\333\21\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\11\3\1\206\24\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\1\3\1\141\34\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\12\3\1\71\23\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\2\3\1\71\33\3\12\0"+
    "\3\334\2\0\1\334\14\0\2\334\1\0\1\334\4\0"+
    "\1\334\3\0\1\334\5\0\11\334\13\0\3\335\2\0"+
    "\1\335\14\0\2\335\1\0\1\335\4\0\1\335\3\0"+
    "\1\335\5\0\11\335\12\0\2\3\1\336\1\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\36\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\1\3\1\323\34\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\1\3\1\337\34\3\11\0"+
    "\2\3\1\223\1\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\36\3\11\0\1\3\1\71\2\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\24\3\11\71"+
    "\1\3\11\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\25\3\1\71\1\3\1\71\2\3\1\71"+
    "\3\3\11\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\3\3\1\323\32\3\11\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\13\3\1\141"+
    "\22\3\11\0\4\3\2\0\1\3\2\0\2\3\4\0"+
    "\1\3\1\0\13\3\1\340\22\3\11\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\2\3\1\163"+
    "\33\3\11\0\2\3\1\120\1\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\36\3\11\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\3\1\0\6\3\1\341"+
    "\27\3\12\0\3\342\2\0\1\342\14\0\2\342\1\0"+
    "\1\342\4\0\1\342\3\0\1\342\5\0\11\342\13\0"+
    "\3\343\2\0\1\343\14\0\2\343\1\0\1\343\4\0"+
    "\1\343\3\0\1\343\5\0\11\343\12\0\4\3\2\0"+
    "\1\3\2\0\2\3\4\0\1\223\1\0\36\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\11\3\1\71\24\3\11\0\4\3\2\0\1\3\2\0"+
    "\2\3\4\0\1\3\1\0\12\3\1\344\23\3\11\0"+
    "\4\3\2\0\1\3\2\0\2\3\4\0\1\3\1\0"+
    "\1\71\35\3\12\0\3\345\2\0\1\345\14\0\2\345"+
    "\1\0\1\345\4\0\1\345\3\0\1\345\5\0\11\345"+
    "\13\0\3\346\2\0\1\346\14\0\2\346\1\0\1\346"+
    "\4\0\1\346\3\0\1\346\5\0\11\346\12\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\1\3"+
    "\1\347\34\3\12\0\3\350\2\0\1\350\14\0\2\350"+
    "\1\0\1\350\4\0\1\350\3\0\1\350\5\0\11\350"+
    "\13\0\3\351\2\0\1\351\14\0\2\351\1\0\1\351"+
    "\4\0\1\351\3\0\1\351\5\0\11\351\12\0\4\3"+
    "\2\0\1\3\2\0\2\3\4\0\1\3\1\0\6\3"+
    "\1\120\27\3\12\0\3\352\2\0\1\352\14\0\2\352"+
    "\1\0\1\352\4\0\1\352\3\0\1\352\5\0\11\352"+
    "\13\0\3\353\2\0\1\353\14\0\2\353\1\0\1\353"+
    "\4\0\1\353\3\0\1\353\5\0\11\353\13\0\3\354"+
    "\2\0\1\354\14\0\2\354\1\0\1\354\4\0\1\354"+
    "\3\0\1\354\5\0\11\354\13\0\3\355\2\0\1\355"+
    "\14\0\2\355\1\0\1\355\4\0\1\355\3\0\1\355"+
    "\5\0\11\355\13\0\3\354\2\0\1\354\4\0\1\356"+
    "\7\0\2\354\1\0\1\354\4\0\1\354\3\0\1\354"+
    "\5\0\11\354\13\0\3\355\2\0\1\355\5\0\1\356"+
    "\6\0\2\355\1\0\1\355\4\0\1\355\3\0\1\355"+
    "\5\0\11\355\11\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[12488];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\12\1\2\11\34\1\1\0\3\1\1\0"+
    "\1\1\2\0\1\1\1\0\46\1\1\0\1\1\1\0"+
    "\4\1\2\0\44\1\1\0\1\1\1\0\1\1\3\0"+
    "\44\1\1\11\2\0\27\1\2\0\15\1\2\0\4\1"+
    "\2\0\1\1\2\0\1\1\6\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[238];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
    public String lexeme;


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 162) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public Tokens yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 4: 
          { lexeme=yytext(); return Operador;
          }
        case 11: break;
        case 1: 
          { return ERROR;
          }
        case 12: break;
        case 8: 
          { lexeme=yytext(); return Reservadas;
          }
        case 13: break;
        case 7: 
          { lexeme=yytext(); return ERROR_Identificador;
          }
        case 14: break;
        case 9: 
          { lexeme=yytext(); return Units;
          }
        case 15: break;
        case 10: 
          { lexeme=yytext(); return Transac;
          }
        case 16: break;
        case 6: 
          { return Linea;
          }
        case 17: break;
        case 3: 
          { lexeme=yytext(); return Literal;
          }
        case 18: break;
        case 5: 
          { /*Ignore*/
          }
        case 19: break;
        case 2: 
          { lexeme=yytext(); return Identificador;
          }
        case 20: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            return null;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
