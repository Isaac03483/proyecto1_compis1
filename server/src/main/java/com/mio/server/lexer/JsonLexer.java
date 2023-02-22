// DO NOT EDIT
// Generated by JFlex 1.9.0 http://jflex.de/
// source: /home/mio/Escritorio/2023/proyecto-1-compis1/server/src/main/jflex/json.jflex

package com.mio.server.lexer;

import com.mio.server.symbols.Token;
//import java_cup.runtime.Symbol;
import static com.mio.server.symbols.TokenSym.*;


@SuppressWarnings("fallthrough")
public class JsonLexer {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int BLOQUE_COMILLAS = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = {
     0,  0,  1, 1
  };

  /**
   * Top-level table for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_TOP = zzUnpackcmap_top();

  private static final String ZZ_CMAP_TOP_PACKED_0 =
    "\1\0\u10ff\u0100";

  private static int [] zzUnpackcmap_top() {
    int [] result = new int[4352];
    int offset = 0;
    offset = zzUnpackcmap_top(ZZ_CMAP_TOP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_top(String packed, int offset, int [] result) {
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
   * Second-level tables for translating characters to character classes
   */
  private static final int [] ZZ_CMAP_BLOCKS = zzUnpackcmap_blocks();

  private static final String ZZ_CMAP_BLOCKS_PACKED_0 =
    "\11\0\1\1\1\2\1\0\1\1\1\3\22\0\1\1"+
    "\1\0\1\4\1\5\4\0\1\6\1\7\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\11\17\1\20\6\0"+
    "\1\21\1\22\1\23\1\24\1\25\1\26\1\24\1\27"+
    "\1\30\1\24\1\31\1\32\2\24\1\33\2\24\1\34"+
    "\5\24\1\35\1\36\1\24\1\37\1\40\1\41\1\40"+
    "\1\42\1\40\1\43\1\44\1\45\1\46\1\47\1\50"+
    "\1\51\1\52\1\53\1\24\1\54\1\55\1\56\1\57"+
    "\1\60\1\61\1\24\1\62\1\63\1\64\1\65\1\24"+
    "\1\66\1\67\1\70\1\24\1\71\1\0\1\72\u0182\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[512];
    int offset = 0;
    offset = zzUnpackcmap_blocks(ZZ_CMAP_BLOCKS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackcmap_blocks(String packed, int offset, int [] result) {
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
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\2\0\1\1\2\2\1\3\1\4\1\5\1\6\2\7"+
    "\1\10\2\1\1\11\1\12\1\13\1\14\1\15\1\1"+
    "\1\16\1\17\1\20\1\21\15\1\4\0\20\22\1\23"+
    "\3\0\2\22\1\24\16\22\1\25\2\0\1\22\1\26"+
    "\4\22\1\27\2\22\1\30\1\22\1\31\1\32\1\33"+
    "\1\22\1\34\2\22\1\35\1\0\1\36\1\37\2\22"+
    "\1\40\6\22\1\41\1\0\3\22\1\42\1\22\1\43"+
    "\2\22\1\44\1\45\6\22\1\46\10\22\1\47\10\22"+
    "\1\50\4\22\1\51\4\22\1\52\1\53\6\22\1\54"+
    "\3\22\1\55";

  private static int [] zzUnpackAction() {
    int [] result = new int[171];
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
    "\0\0\0\73\0\166\0\166\0\261\0\166\0\166\0\166"+
    "\0\166\0\354\0\u0127\0\166\0\u0162\0\u019d\0\166\0\166"+
    "\0\166\0\166\0\166\0\u01d8\0\166\0\166\0\166\0\166"+
    "\0\u0213\0\u024e\0\u0289\0\u02c4\0\u02ff\0\u033a\0\u0375\0\u03b0"+
    "\0\u03eb\0\u0426\0\u0461\0\u049c\0\u04d7\0\u0512\0\u054d\0\u0588"+
    "\0\u05c3\0\u05fe\0\u0639\0\u0674\0\u06af\0\u06ea\0\u0725\0\u0760"+
    "\0\u079b\0\u07d6\0\u0811\0\u084c\0\u0887\0\u08c2\0\u08fd\0\u0938"+
    "\0\u0973\0\u0512\0\u09ae\0\u09e9\0\u0a24\0\u0a5f\0\u0a9a\0\u05fe"+
    "\0\u0ad5\0\u0b10\0\u0b4b\0\u0b86\0\u0bc1\0\u0bfc\0\u0c37\0\u0c72"+
    "\0\u0cad\0\u0ce8\0\u0d23\0\u0d5e\0\u0d99\0\u0dd4\0\166\0\u0e0f"+
    "\0\u0e4a\0\u0e85\0\u05fe\0\u0ec0\0\u0efb\0\u0f36\0\u0f71\0\u05fe"+
    "\0\u0fac\0\u0fe7\0\u05fe\0\u1022\0\u05fe\0\u05fe\0\u05fe\0\u105d"+
    "\0\u05fe\0\u1098\0\u10d3\0\166\0\u110e\0\u05fe\0\u05fe\0\u1149"+
    "\0\u1184\0\u05fe\0\u11bf\0\u11fa\0\u1235\0\u1270\0\u12ab\0\u12e6"+
    "\0\u1321\0\u135c\0\u1397\0\u13d2\0\u140d\0\u05fe\0\u1448\0\u1483"+
    "\0\u14be\0\u14f9\0\u05fe\0\166\0\u1534\0\u156f\0\u15aa\0\u15e5"+
    "\0\u1620\0\u165b\0\u05fe\0\u1696\0\u16d1\0\u170c\0\u1747\0\u1782"+
    "\0\u17bd\0\u17f8\0\u1833\0\u05fe\0\u186e\0\u18a9\0\u18e4\0\u191f"+
    "\0\u195a\0\u1995\0\u19d0\0\u1a0b\0\u05fe\0\u1a46\0\u1a81\0\u1abc"+
    "\0\u1af7\0\u05fe\0\u1b32\0\u1b6d\0\u1ba8\0\u1be3\0\u05fe\0\u05fe"+
    "\0\u1c1e\0\u1c59\0\u1c94\0\u1ccf\0\u1d0a\0\u1d45\0\u05fe\0\u1d80"+
    "\0\u1dbb\0\u1df6\0\u05fe";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[171];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length() - 1;
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /**
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpacktrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\3\2\4\1\5\1\6\1\3\1\7\1\10\2\3"+
    "\1\11\3\3\1\12\1\13\1\14\2\3\1\15\2\3"+
    "\1\16\10\3\1\17\1\3\1\20\27\3\1\21\1\22"+
    "\1\3\2\4\1\5\1\23\1\24\2\3\1\25\1\26"+
    "\1\3\1\27\1\3\1\30\1\12\1\13\1\3\1\31"+
    "\1\32\4\31\1\33\7\31\3\3\1\31\1\34\1\35"+
    "\1\36\4\31\1\37\4\31\1\40\1\31\1\41\1\42"+
    "\1\31\1\43\1\44\1\45\2\31\2\3\75\0\1\4"+
    "\104\0\1\46\72\0\1\46\1\0\2\13\100\0\1\47"+
    "\77\0\1\50\56\0\2\51\23\0\6\51\43\0\50\52"+
    "\23\0\13\52\1\53\34\52\23\0\1\54\47\52\23\0"+
    "\34\52\1\55\13\52\23\0\37\52\1\56\1\52\1\57"+
    "\6\52\23\0\37\52\1\60\10\52\23\0\22\52\1\61"+
    "\25\52\23\0\22\52\1\62\25\52\23\0\34\52\1\63"+
    "\2\52\1\64\10\52\23\0\37\52\1\65\10\52\23\0"+
    "\22\52\1\66\24\52\1\67\23\0\36\52\1\70\11\52"+
    "\23\0\37\52\1\71\10\52\20\0\2\72\103\0\1\73"+
    "\75\0\1\74\55\0\2\75\23\0\6\75\40\0\2\52"+
    "\1\0\50\52\20\0\2\52\1\0\7\52\1\76\40\52"+
    "\20\0\2\52\1\0\11\52\1\77\36\52\20\0\2\52"+
    "\1\0\34\52\1\100\13\52\20\0\2\52\1\0\22\52"+
    "\1\101\23\52\1\102\1\52\20\0\2\52\1\0\32\52"+
    "\1\103\15\52\20\0\2\52\1\0\34\52\1\104\1\52"+
    "\1\105\11\52\20\0\2\52\1\0\34\52\1\106\13\52"+
    "\20\0\2\52\1\0\35\52\1\107\12\52\20\0\2\52"+
    "\1\0\22\52\1\110\25\52\20\0\2\52\1\0\42\52"+
    "\1\111\5\52\20\0\2\52\1\0\45\52\1\112\2\52"+
    "\20\0\2\52\1\0\41\52\1\113\6\52\20\0\2\52"+
    "\1\0\40\52\1\114\7\52\20\0\2\52\1\0\25\52"+
    "\1\115\22\52\20\0\2\52\1\0\41\52\1\116\6\52"+
    "\34\0\1\117\73\0\1\120\55\0\2\121\23\0\6\121"+
    "\40\0\2\52\1\0\2\52\1\122\45\52\20\0\2\52"+
    "\1\0\11\52\1\123\36\52\20\0\2\52\1\0\41\52"+
    "\1\124\6\52\20\0\2\52\1\0\21\52\1\125\4\52"+
    "\1\126\21\52\20\0\2\52\1\0\24\52\1\127\23\52"+
    "\20\0\2\52\1\0\42\52\1\130\5\52\20\0\2\52"+
    "\1\0\27\52\1\131\20\52\20\0\2\52\1\0\34\52"+
    "\1\132\13\52\20\0\2\52\1\0\26\52\1\133\21\52"+
    "\20\0\2\52\1\0\47\52\1\134\20\0\2\52\1\0"+
    "\14\52\1\135\1\136\32\52\20\0\2\52\1\0\42\52"+
    "\1\137\5\52\20\0\2\52\1\0\30\52\1\140\17\52"+
    "\20\0\2\52\1\0\26\52\1\141\21\52\20\0\2\52"+
    "\1\0\26\52\1\142\21\52\20\0\2\52\1\0\34\52"+
    "\1\143\13\52\36\0\1\144\54\0\2\145\23\0\6\145"+
    "\40\0\2\52\1\0\10\52\1\146\37\52\20\0\2\52"+
    "\1\0\25\52\1\147\22\52\20\0\2\52\1\0\24\52"+
    "\1\150\12\52\1\151\10\52\20\0\2\52\1\0\42\52"+
    "\1\152\5\52\20\0\2\52\1\0\33\52\1\153\14\52"+
    "\20\0\2\52\1\0\32\52\1\154\15\52\20\0\2\52"+
    "\1\0\21\52\1\155\26\52\20\0\2\52\1\0\26\52"+
    "\1\156\21\52\20\0\2\52\1\0\26\52\1\157\21\52"+
    "\20\0\2\52\1\0\27\52\1\160\20\52\20\0\2\52"+
    "\1\0\25\52\1\161\22\52\20\0\2\162\23\0\6\162"+
    "\40\0\2\52\1\0\37\52\1\163\10\52\20\0\2\52"+
    "\1\0\36\52\1\164\11\52\20\0\2\52\1\0\21\52"+
    "\1\165\26\52\20\0\2\52\1\0\30\52\1\166\17\52"+
    "\20\0\2\52\1\0\24\52\1\167\23\52\20\0\2\52"+
    "\1\0\41\52\1\170\6\52\20\0\2\52\1\0\43\52"+
    "\1\171\4\52\20\0\2\52\1\0\32\52\1\172\15\52"+
    "\20\0\2\52\1\0\42\52\1\173\5\52\20\0\2\174"+
    "\23\0\6\174\40\0\2\52\1\0\34\52\1\175\13\52"+
    "\20\0\2\52\1\0\21\52\1\176\26\52\20\0\2\52"+
    "\1\0\24\52\1\177\23\52\20\0\2\52\1\0\37\52"+
    "\1\200\10\52\20\0\2\52\1\0\21\52\1\201\26\52"+
    "\20\0\2\52\1\0\21\52\1\202\20\52\1\203\5\52"+
    "\20\0\2\52\1\0\36\52\1\204\11\52\20\0\2\52"+
    "\1\0\37\52\1\205\10\52\20\0\2\52\1\0\43\52"+
    "\1\206\4\52\20\0\2\52\1\0\37\52\1\207\10\52"+
    "\20\0\2\52\1\0\34\52\1\210\13\52\20\0\2\52"+
    "\1\0\24\52\1\211\23\52\20\0\2\52\1\0\24\52"+
    "\1\212\23\52\20\0\2\52\1\0\26\52\1\213\21\52"+
    "\20\0\2\52\1\0\41\52\1\214\6\52\20\0\2\52"+
    "\1\0\22\52\1\215\25\52\20\0\2\52\1\0\34\52"+
    "\1\216\13\52\20\0\2\52\1\0\37\52\1\217\10\52"+
    "\20\0\2\52\1\0\37\52\1\220\10\52\20\0\2\52"+
    "\1\0\37\52\1\221\10\52\20\0\2\52\1\0\25\52"+
    "\1\222\22\52\20\0\2\52\1\0\41\52\1\223\6\52"+
    "\20\0\2\52\1\0\37\52\1\224\10\52\20\0\2\52"+
    "\1\0\41\52\1\225\6\52\20\0\2\52\1\0\34\52"+
    "\1\226\13\52\20\0\2\52\1\0\34\52\1\227\13\52"+
    "\20\0\2\52\1\0\21\52\1\230\26\52\20\0\2\52"+
    "\1\0\30\52\1\231\17\52\20\0\2\52\1\0\41\52"+
    "\1\232\6\52\20\0\2\52\1\0\37\52\1\233\10\52"+
    "\20\0\2\52\1\0\37\52\1\234\10\52\20\0\2\52"+
    "\1\0\24\52\1\235\23\52\20\0\2\52\1\0\26\52"+
    "\1\236\21\52\20\0\2\52\1\0\41\52\1\237\6\52"+
    "\20\0\2\52\1\0\41\52\1\240\6\52\20\0\2\52"+
    "\1\0\37\52\1\241\10\52\20\0\2\52\1\0\43\52"+
    "\1\242\4\52\20\0\2\52\1\0\34\52\1\243\13\52"+
    "\20\0\2\52\1\0\21\52\1\244\26\52\20\0\2\52"+
    "\1\0\37\52\1\245\10\52\20\0\2\52\1\0\24\52"+
    "\1\246\23\52\20\0\2\52\1\0\41\52\1\247\6\52"+
    "\20\0\2\52\1\0\37\52\1\250\10\52\20\0\2\52"+
    "\1\0\34\52\1\251\13\52\20\0\2\52\1\0\37\52"+
    "\1\252\10\52\20\0\2\52\1\0\41\52\1\253\6\52"+
    "\2\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[7729];
    int offset = 0;
    offset = zzUnpacktrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpacktrans(String packed, int offset, int [] result) {
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


  /** Error code for "Unknown internal scanner error". */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  /** Error code for "could not match input". */
  private static final int ZZ_NO_MATCH = 1;
  /** Error code for "pushback value was too large". */
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /**
   * Error messages for {@link #ZZ_UNKNOWN_ERROR}, {@link #ZZ_NO_MATCH}, and
   * {@link #ZZ_PUSHBACK_2BIG} respectively.
   */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state {@code aState}
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\2\0\2\11\1\1\4\11\2\1\1\11\2\1\5\11"+
    "\1\1\4\11\15\1\4\0\21\1\3\0\21\1\1\11"+
    "\2\0\22\1\1\11\1\0\14\1\1\0\11\1\1\11"+
    "\57\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[171];
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

  /** Input device. */
  private java.io.Reader zzReader;

  /** Current state of the DFA. */
  private int zzState;

  /** Current lexical state. */
  private int zzLexicalState = YYINITIAL;

  /**
   * This buffer contains the current text to be matched and is the source of the {@link #yytext()}
   * string.
   */
  private char zzBuffer[] = new char[Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen())];

  /** Text position at the last accepting state. */
  private int zzMarkedPos;

  /** Current text position in the buffer. */
  private int zzCurrentPos;

  /** Marks the beginning of the {@link #yytext()} string in the buffer. */
  private int zzStartRead;

  /** Marks the last character in the buffer, that has been read from input. */
  private int zzEndRead;

  /**
   * Whether the scanner is at the end of file.
   * @see #yyatEOF
   */
  private boolean zzAtEOF;

  /**
   * The number of occupied positions in {@link #zzBuffer} beyond {@link #zzEndRead}.
   *
   * <p>When a lead/high surrogate has been read from the input stream into the final
   * {@link #zzBuffer} position, this will have a value of 1; otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /** Number of newlines encountered up to the start of the matched text. */
  private int yyline;

  /** Number of characters from the last newline up to the start of the matched text. */
  private int yycolumn;

  /** Number of characters up to the start of the matched text. */
  @SuppressWarnings("unused")
  private long yychar;

  /** Whether the scanner is currently at the beginning of a line. */
  @SuppressWarnings("unused")
  private boolean zzAtBOL = true;

  /** Whether the user-EOF-code has already been executed. */
  private boolean zzEOFDone;

  /* user code: */
    private Token symbolWithValue(int type, Object value){
        Token token = new Token(type, value.toString(), yyline+1, yycolumn+1 );
        System.out.println(token);
        return token;
    }

    private Token symbolWithoutValue(int type){
        Token token = new Token(type, null, yyline+1, yycolumn+1 );
        System.out.println(token);
        return token;
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public JsonLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** Returns the maximum size of the scanner buffer, which limits the size of tokens. */
  private int zzMaxBufferLen() {
    return Integer.MAX_VALUE;
  }

  /**  Whether the scanner buffer can grow to accommodate a larger token. */
  private boolean zzCanGrow() {
    return true;
  }

  /**
   * Translates raw input code points to DFA table row
   */
  private static int zzCMap(int input) {
    int offset = input & 255;
    return offset == input ? ZZ_CMAP_BLOCKS[offset] : ZZ_CMAP_BLOCKS[ZZ_CMAP_TOP[input >> 8] | offset];
  }

  /**
   * Refills the input buffer.
   *
   * @return {@code false} iff there was new input.
   * @exception java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead - zzStartRead);

      /* translate stored positions */
      zzEndRead -= zzStartRead;
      zzCurrentPos -= zzStartRead;
      zzMarkedPos -= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate && zzCanGrow()) {
      /* if not, and it can grow: blow it up */
      char newBuffer[] = new char[Math.min(zzBuffer.length * 2, zzMaxBufferLen())];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      if (requested == 0) {
        throw new java.io.EOFException("Scan buffer limit reached ["+zzBuffer.length+"]");
      }
      else {
        throw new java.io.IOException(
            "Reader returned 0 characters. See JFlex examples/zero-reader for a workaround.");
      }
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
        if (numRead == requested) { // We requested too few chars to encode a full Unicode character
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        } else {                    // There is room in the buffer for at least one more char
          int c = zzReader.read();  // Expecting to read a paired low surrogate char
          if (c == -1) {
            return true;
          } else {
            zzBuffer[zzEndRead++] = (char)c;
          }
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }


  /**
   * Closes the input reader.
   *
   * @throws java.io.IOException if the reader could not be closed.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true; // indicate end of file
    zzEndRead = zzStartRead; // invalidate buffer

    if (zzReader != null) {
      zzReader.close();
    }
  }


  /**
   * Resets the scanner to read from a new input stream.
   *
   * <p>Does not close the old reader.
   *
   * <p>All internal variables are reset, the old input stream <b>cannot</b> be reused (internal
   * buffer is discarded and lost). Lexical state is set to {@code ZZ_INITIAL}.
   *
   * <p>Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader The new input stream.
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzEOFDone = false;
    yyResetPosition();
    zzLexicalState = YYINITIAL;
    int initBufferSize = Math.min(ZZ_BUFFERSIZE, zzMaxBufferLen());
    if (zzBuffer.length > initBufferSize) {
      zzBuffer = new char[initBufferSize];
    }
  }

  /**
   * Resets the input position.
   */
  private final void yyResetPosition() {
      zzAtBOL  = true;
      zzAtEOF  = false;
      zzCurrentPos = 0;
      zzMarkedPos = 0;
      zzStartRead = 0;
      zzEndRead = 0;
      zzFinalHighSurrogate = 0;
      yyline = 0;
      yycolumn = 0;
      yychar = 0L;
  }


  /**
   * Returns whether the scanner has reached the end of the reader it reads from.
   *
   * @return whether the scanner has reached EOF.
   */
  public final boolean yyatEOF() {
    return zzAtEOF;
  }


  /**
   * Returns the current lexical state.
   *
   * @return the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state.
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   *
   * @return the matched text.
   */
  public final String yytext() {
    return new String(zzBuffer, zzStartRead, zzMarkedPos-zzStartRead);
  }


  /**
   * Returns the character at the given position from the matched text.
   *
   * <p>It is equivalent to {@code yytext().charAt(pos)}, but faster.
   *
   * @param position the position of the character to fetch. A value from 0 to {@code yylength()-1}.
   *
   * @return the character at {@code position}.
   */
  public final char yycharat(int position) {
    return zzBuffer[zzStartRead + position];
  }


  /**
   * How many characters were matched.
   *
   * @return the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * <p>In a well-formed scanner (no or only correct usage of {@code yypushback(int)} and a
   * match-all fallback rule) this method will only be called with things that
   * "Can't Possibly Happen".
   *
   * <p>If this method is called, something is seriously wrong (e.g. a JFlex bug producing a faulty
   * scanner etc.).
   *
   * <p>Usual syntax/scanner level error handling should be done in error fallback rules.
   *
   * @param errorCode the code of the error message to display.
   */
  private static void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    } catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * <p>They will be read again by then next call of the scanning method.
   *
   * @param number the number of characters to be read again. This number must not be greater than
   *     {@link #yylength()}.
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
    
  yyclose();    }
  }




  /**
   * Resumes scanning until the next regular expression is matched, the end of input is encountered
   * or an I/O-Error occurs.
   *
   * @return the next token.
   * @exception java.io.IOException if any I/O-Error occurs.
   */
  public Token yylex() throws java.io.IOException
  {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char[] zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is
        // (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof)
            zzPeek = false;
          else
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
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
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMap(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          {     return symbolWithoutValue(EOF);
 }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1:
            { System.out.println("Error: <" + yytext() + ">");
            }
          // fall through
          case 46: break;
          case 2:
            { ;
            }
          // fall through
          case 47: break;
          case 3:
            { yybegin(BLOQUE_COMILLAS);
        return symbolWithoutValue(COMILLA);
            }
          // fall through
          case 48: break;
          case 4:
            { return symbolWithoutValue(PARENTESIS_A);
            }
          // fall through
          case 49: break;
          case 5:
            { return symbolWithoutValue(PARENTESIS_C);
            }
          // fall through
          case 50: break;
          case 6:
            { return symbolWithoutValue(COMA);
            }
          // fall through
          case 51: break;
          case 7:
            { return symbolWithValue(ENTERO, yytext());
            }
          // fall through
          case 52: break;
          case 8:
            { return symbolWithoutValue(DOS_PUNTOS);
            }
          // fall through
          case 53: break;
          case 9:
            { return symbolWithoutValue(CORCHETE_A);
            }
          // fall through
          case 54: break;
          case 10:
            { return symbolWithoutValue(CORCHETE_C);
            }
          // fall through
          case 55: break;
          case 11:
            { return symbolWithoutValue(LLAVE_A);
            }
          // fall through
          case 56: break;
          case 12:
            { return symbolWithoutValue(LLAVE_C);
            }
          // fall through
          case 57: break;
          case 13:
            { yybegin(YYINITIAL);
        return symbolWithoutValue(COMILLA);
            }
          // fall through
          case 58: break;
          case 14:
            { return symbolWithoutValue(MULTIPLICACION);
            }
          // fall through
          case 59: break;
          case 15:
            { return symbolWithoutValue(SUMA);
            }
          // fall through
          case 60: break;
          case 16:
            { return symbolWithoutValue(RESTA);
            }
          // fall through
          case 61: break;
          case 17:
            { return symbolWithoutValue(DIVISION);
            }
          // fall through
          case 62: break;
          case 18:
            { return symbolWithValue(PALABRA, yytext());
            }
          // fall through
          case 63: break;
          case 19:
            { return symbolWithValue(DECIMAL, yytext());
            }
          // fall through
          case 64: break;
          case 20:
            { return symbolWithoutValue(ALL);
            }
          // fall through
          case 65: break;
          case 21:
            { return symbolWithoutValue(CEIL);
            }
          // fall through
          case 66: break;
          case 22:
            { return symbolWithoutValue(HALL);
            }
          // fall through
          case 67: break;
          case 23:
            { return symbolWithoutValue(COLS);
            }
          // fall through
          case 68: break;
          case 24:
            { return symbolWithoutValue(NAME);
            }
          // fall through
          case 69: break;
          case 25:
            { return symbolWithoutValue(POS_X);
            }
          // fall through
          case 70: break;
          case 26:
            { return symbolWithoutValue(POS_Y);
            }
          // fall through
          case 71: break;
          case 27:
            { return symbolWithoutValue(ROWS);
            }
          // fall through
          case 72: break;
          case 28:
            { return symbolWithoutValue(TYPE);
            }
          // fall through
          case 73: break;
          case 29:
            { return symbolWithoutValue(FLOOR);
            }
          // fall through
          case 74: break;
          case 30:
            { return symbolWithoutValue(BRICK);
            }
          // fall through
          case 75: break;
          case 31:
            { return symbolWithoutValue(BOARD);
            }
          // fall through
          case 76: break;
          case 32:
            { return symbolWithoutValue(BOXES);
            }
          // fall through
          case 77: break;
          case 33:
            { return symbolWithoutValue(WORLD);
            }
          // fall through
          case 78: break;
          case 34:
            { return symbolWithoutValue(CONFIG);
            }
          // fall through
          case 79: break;
          case 35:
            { return symbolWithoutValue(PLAYER);
            }
          // fall through
          case 80: break;
          case 36:
            { return symbolWithoutValue(WORLDS);
            }
          // fall through
          case 81: break;
          case 37:
            { return symbolWithValue(HEXADECIMAL, yytext());
            }
          // fall through
          case 82: break;
          case 38:
            { return symbolWithoutValue(TARGETS);
            }
          // fall through
          case 83: break;
          case 39:
            { return symbolWithoutValue(BOX_COLOR);
            }
          // fall through
          case 84: break;
          case 40:
            { return symbolWithoutValue(HALL_COLOR);
            }
          // fall through
          case 85: break;
          case 41:
            { return symbolWithoutValue(BRICK_COLOR);
            }
          // fall through
          case 86: break;
          case 42:
            { return symbolWithoutValue(PLAYER_COLOR);
            }
          // fall through
          case 87: break;
          case 43:
            { return symbolWithoutValue(TARGET_COLOR);
            }
          // fall through
          case 88: break;
          case 44:
            { return symbolWithoutValue(UNDEFINED_COLOR);
            }
          // fall through
          case 89: break;
          case 45:
            { return symbolWithoutValue(BOX_ON_TARGET_COLOR);
            }
          // fall through
          case 90: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
