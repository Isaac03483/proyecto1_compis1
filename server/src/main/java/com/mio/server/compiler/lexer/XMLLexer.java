// DO NOT EDIT
// Generated by JFlex 1.9.0 http://jflex.de/
// source: /home/mio/Escritorio/2023/proyecto-1-compis1/server/src/main/jflex/xml.jflex

package com.mio.server.compiler.lexer;

import static com.mio.server.compiler.parser.XMLParserSym.*;
import com.mio.server.compiler.Token;
import java_cup.runtime.Symbol;

/*
compilar archivo.jflex
java -jar jflex-full-1.9.0.jar /home/mio/Escritorio/2023/proyecto-1-compis1/Boxworld/app/src/main/jflex/xml.jflex
*/


@SuppressWarnings("fallthrough")
public class XMLLexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file. */
  public static final int YYEOF = -1;

  /** Initial size of the lookahead buffer. */
  private static final int ZZ_BUFFERSIZE = 16384;

  // Lexical states.
  public static final int YYINITIAL = 0;
  public static final int ESTADO_COMILLAS = 2;

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
    "\1\0\5\u0100\1\u0200\1\u0300\1\u0100\5\u0400\1\u0500\1\u0600"+
    "\1\u0700\6\u0100\1\u0800\1\u0900\1\u0a00\1\u0b00\1\u0c00\1\u0d00"+
    "\211\u0100\1\u0600\1\u0100\1\u0e00\1\u0f00\1\u1000\1\u1100\123\u0100"+
    "\1\u0900\4\u0100\1\u1200\10\u0100\1\u1300\2\u0100\1\u1400\1\u1500"+
    "\1\u1100\1\u0100\1\u0500\1\u0100\1\u1600\1\u1300\1\u0800\3\u0100"+
    "\1\u1000\1\u1700\114\u0100\1\u1800\1\u1000\153\u0100\1\u1900\11\u0100"+
    "\1\u1a00\1\u1100\6\u0100\1\u1000\u0f16\u0100";

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
    "\1\0\1\4\1\5\11\0\1\6\1\7\1\10\1\11"+
    "\11\12\2\0\1\13\1\14\1\15\1\16\1\0\1\17"+
    "\1\20\1\21\4\22\1\23\1\24\1\22\1\25\1\26"+
    "\5\22\1\27\5\22\1\30\1\31\1\22\4\32\1\33"+
    "\1\32\1\34\1\35\1\36\1\37\1\40\1\41\1\42"+
    "\1\43\1\44\1\22\1\45\1\46\1\47\1\50\1\51"+
    "\1\52\1\22\1\53\1\54\1\55\1\56\1\57\1\60"+
    "\1\61\1\62\1\22\u01e5\0\12\63\206\0\12\63\306\0"+
    "\12\63\234\0\12\63\166\0\12\63\140\0\12\63\166\0"+
    "\12\63\106\0\12\63\u0116\0\12\63\106\0\12\63\u0146\0"+
    "\12\63\46\0\12\63\u012c\0\12\63\200\0\12\63\246\0"+
    "\12\63\6\0\12\63\266\0\12\63\126\0\12\63\206\0"+
    "\12\63\6\0\12\63\u0176\0\12\63\46\0\12\63\306\0"+
    "\12\63\26\0\12\63\126\0\12\63\u0196\0\12\63\246\0"+
    "\12\63\206\0\12\63\u012c\0\12\63\200\0\12\63\74\0"+
    "\12\63\220\0\12\63\166\0\12\63\146\0\12\63\206\0"+
    "\12\63\106\0\12\63\266\0\12\63\u0164\0\62\63\100\0"+
    "\12\63\266\0";

  private static int [] zzUnpackcmap_blocks() {
    int [] result = new int[6912];
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
    "\2\0\1\1\2\2\1\3\1\1\1\4\2\5\1\6"+
    "\1\7\1\10\1\11\17\1\1\12\2\13\1\1\1\0"+
    "\22\14\3\0\22\14\1\15\1\13\2\0\1\14\1\16"+
    "\4\14\1\17\3\14\1\20\1\14\1\21\1\22\1\23"+
    "\1\14\1\24\3\14\1\0\1\25\1\26\2\14\1\27"+
    "\10\14\1\30\1\0\3\14\1\31\2\14\1\32\3\14"+
    "\1\33\1\34\7\14\1\35\1\14\1\36\3\14\1\37"+
    "\4\14\1\40\10\14\1\41\4\14\1\42\4\14\1\43"+
    "\1\44\6\14\1\45\3\14\1\46";

  private static int [] zzUnpackAction() {
    int [] result = new int[175];
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
    "\0\0\0\64\0\150\0\150\0\234\0\150\0\320\0\150"+
    "\0\150\0\u0104\0\150\0\150\0\150\0\150\0\u0138\0\u016c"+
    "\0\u01a0\0\u01d4\0\u0208\0\u023c\0\u0270\0\u02a4\0\u02d8\0\u030c"+
    "\0\u0340\0\u0374\0\u03a8\0\u03dc\0\u0410\0\150\0\u0444\0\u0478"+
    "\0\u04ac\0\u04e0\0\u0514\0\u0548\0\u057c\0\u05b0\0\u05e4\0\u0618"+
    "\0\u064c\0\u0680\0\u06b4\0\u06e8\0\u071c\0\u0750\0\u0784\0\u07b8"+
    "\0\u07ec\0\u0820\0\u0854\0\u0888\0\u08bc\0\u08f0\0\u0924\0\u0958"+
    "\0\u098c\0\u09c0\0\u09f4\0\u0a28\0\u0a5c\0\u0a90\0\u0ac4\0\u0af8"+
    "\0\u0b2c\0\u0b60\0\u0b94\0\u0bc8\0\u0bfc\0\u0c30\0\u0c64\0\u0c98"+
    "\0\u0ccc\0\u0514\0\u08bc\0\u0d00\0\u0d34\0\u0d68\0\u0514\0\u0d9c"+
    "\0\u0dd0\0\u0e04\0\u0e38\0\u0514\0\u0e6c\0\u0ea0\0\u0ed4\0\u0514"+
    "\0\u0f08\0\u0514\0\u0514\0\u0514\0\u0f3c\0\u0514\0\u0f70\0\u0fa4"+
    "\0\u0fd8\0\u100c\0\u0514\0\u0514\0\u1040\0\u1074\0\u0514\0\u10a8"+
    "\0\u10dc\0\u1110\0\u1144\0\u1178\0\u11ac\0\u11e0\0\u1214\0\u1248"+
    "\0\u127c\0\u12b0\0\u12e4\0\u1318\0\u0514\0\u134c\0\u1380\0\u13b4"+
    "\0\u13e8\0\u141c\0\u1450\0\u0514\0\150\0\u1484\0\u14b8\0\u14ec"+
    "\0\u1520\0\u1554\0\u1588\0\u15bc\0\u0514\0\u15f0\0\u0514\0\u1624"+
    "\0\u1658\0\u168c\0\u0514\0\u16c0\0\u16f4\0\u1728\0\u175c\0\u0514"+
    "\0\u1790\0\u17c4\0\u17f8\0\u182c\0\u1860\0\u1894\0\u18c8\0\u18fc"+
    "\0\u0514\0\u1930\0\u1964\0\u1998\0\u19cc\0\u0514\0\u1a00\0\u1a34"+
    "\0\u1a68\0\u1a9c\0\u0514\0\u0514\0\u1ad0\0\u1b04\0\u1b38\0\u1b6c"+
    "\0\u1ba0\0\u1bd4\0\u0514\0\u1c08\0\u1c3c\0\u1c70\0\u0514";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[175];
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
    "\1\3\2\4\1\5\1\6\1\7\2\3\1\10\1\11"+
    "\1\12\1\13\1\14\1\15\1\16\1\17\1\20\2\17"+
    "\1\21\6\17\1\3\2\17\1\22\1\23\1\17\1\24"+
    "\2\17\1\25\4\17\1\26\1\17\1\27\1\30\1\17"+
    "\1\31\1\32\1\33\1\34\1\35\1\17\2\3\2\4"+
    "\1\5\1\36\4\3\1\37\1\40\4\3\13\41\1\3"+
    "\30\41\1\3\66\0\1\4\72\0\2\42\21\0\6\42"+
    "\33\0\2\12\70\0\44\43\20\0\10\43\1\44\33\43"+
    "\20\0\1\45\43\43\20\0\32\43\1\46\1\43\1\47"+
    "\7\43\20\0\32\43\1\50\11\43\20\0\31\43\1\51"+
    "\12\43\20\0\15\43\1\52\26\43\20\0\15\43\1\53"+
    "\26\43\20\0\27\43\1\54\2\43\1\55\11\43\20\0"+
    "\32\43\1\56\11\43\20\0\15\43\1\57\25\43\1\60"+
    "\20\0\31\43\1\61\12\43\20\0\21\43\1\62\22\43"+
    "\20\0\32\43\1\63\11\43\20\0\30\43\1\64\13\43"+
    "\10\0\1\65\63\0\1\65\1\0\2\40\70\0\44\66"+
    "\12\0\2\67\21\0\6\67\33\0\2\43\4\0\44\43"+
    "\12\0\2\43\4\0\5\43\1\70\36\43\12\0\2\43"+
    "\4\0\7\43\1\71\34\43\12\0\2\43\4\0\15\43"+
    "\1\72\24\43\1\73\1\43\12\0\2\43\4\0\25\43"+
    "\1\74\16\43\12\0\2\43\4\0\27\43\1\75\1\43"+
    "\1\76\12\43\12\0\2\43\4\0\17\43\1\77\24\43"+
    "\12\0\2\43\4\0\27\43\1\100\14\43\12\0\2\43"+
    "\4\0\30\43\1\101\13\43\12\0\2\43\4\0\15\43"+
    "\1\102\26\43\12\0\2\43\4\0\35\43\1\103\6\43"+
    "\12\0\2\43\4\0\41\43\1\104\2\43\12\0\2\43"+
    "\4\0\34\43\1\105\7\43\12\0\2\43\4\0\33\43"+
    "\1\106\10\43\12\0\2\43\4\0\20\43\1\107\23\43"+
    "\12\0\2\43\4\0\34\43\1\110\7\43\12\0\2\43"+
    "\4\0\34\43\1\111\7\43\12\0\2\43\4\0\27\43"+
    "\1\112\14\43\12\0\2\113\50\0\1\113\6\0\1\114"+
    "\2\0\2\66\4\0\44\66\12\0\2\115\21\0\6\115"+
    "\33\0\2\43\4\0\2\43\1\116\41\43\12\0\2\43"+
    "\4\0\7\43\1\117\34\43\12\0\2\43\4\0\34\43"+
    "\1\120\7\43\12\0\2\43\4\0\14\43\1\121\4\43"+
    "\1\122\22\43\12\0\2\43\4\0\17\43\1\123\24\43"+
    "\12\0\2\43\4\0\35\43\1\124\6\43\12\0\2\43"+
    "\4\0\22\43\1\125\21\43\12\0\2\43\4\0\32\43"+
    "\1\126\11\43\12\0\2\43\4\0\27\43\1\127\14\43"+
    "\12\0\2\43\4\0\21\43\1\130\22\43\12\0\2\43"+
    "\4\0\43\43\1\131\12\0\2\43\4\0\11\43\1\132"+
    "\1\133\31\43\12\0\2\43\4\0\35\43\1\134\6\43"+
    "\12\0\2\43\4\0\23\43\1\135\20\43\12\0\2\43"+
    "\4\0\21\43\1\136\22\43\12\0\2\43\4\0\21\43"+
    "\1\137\22\43\12\0\2\43\4\0\35\43\1\140\6\43"+
    "\12\0\2\43\4\0\27\43\1\141\14\43\12\0\1\37"+
    "\1\40\62\0\2\142\21\0\6\142\33\0\2\43\4\0"+
    "\6\43\1\143\35\43\12\0\2\43\4\0\20\43\1\144"+
    "\23\43\12\0\2\43\4\0\17\43\1\145\12\43\1\146"+
    "\11\43\12\0\2\43\4\0\35\43\1\147\6\43\12\0"+
    "\2\43\4\0\26\43\1\150\15\43\12\0\2\43\4\0"+
    "\25\43\1\151\16\43\12\0\2\43\4\0\20\43\1\152"+
    "\23\43\12\0\2\43\4\0\14\43\1\153\27\43\12\0"+
    "\2\43\4\0\21\43\1\154\22\43\12\0\2\43\4\0"+
    "\21\43\1\155\22\43\12\0\2\43\4\0\22\43\1\156"+
    "\21\43\12\0\2\43\4\0\25\43\1\157\16\43\12\0"+
    "\2\43\4\0\20\43\1\160\23\43\12\0\2\161\21\0"+
    "\6\161\33\0\2\43\4\0\32\43\1\162\11\43\12\0"+
    "\2\43\4\0\31\43\1\163\12\43\12\0\2\43\4\0"+
    "\14\43\1\164\27\43\12\0\2\43\4\0\23\43\1\165"+
    "\20\43\12\0\2\43\4\0\25\43\1\166\16\43\12\0"+
    "\2\43\4\0\17\43\1\167\24\43\12\0\2\43\4\0"+
    "\34\43\1\170\7\43\12\0\2\43\4\0\36\43\1\171"+
    "\5\43\12\0\2\43\4\0\25\43\1\172\16\43\12\0"+
    "\2\43\4\0\32\43\1\173\11\43\12\0\2\43\4\0"+
    "\35\43\1\174\6\43\12\0\2\175\21\0\6\175\33\0"+
    "\2\43\4\0\27\43\1\176\14\43\12\0\2\43\4\0"+
    "\14\43\1\177\27\43\12\0\2\43\4\0\17\43\1\200"+
    "\24\43\12\0\2\43\4\0\31\43\1\201\12\43\12\0"+
    "\2\43\4\0\32\43\1\202\11\43\12\0\2\43\4\0"+
    "\14\43\1\203\27\43\12\0\2\43\4\0\14\43\1\204"+
    "\20\43\1\205\6\43\12\0\2\43\4\0\31\43\1\206"+
    "\12\43\12\0\2\43\4\0\31\43\1\207\12\43\12\0"+
    "\2\43\4\0\32\43\1\210\11\43\12\0\2\43\4\0"+
    "\36\43\1\211\5\43\12\0\2\43\4\0\32\43\1\212"+
    "\11\43\12\0\2\43\4\0\23\43\1\213\20\43\12\0"+
    "\2\43\4\0\27\43\1\214\14\43\12\0\2\43\4\0"+
    "\17\43\1\215\24\43\12\0\2\43\4\0\17\43\1\216"+
    "\24\43\12\0\2\43\4\0\21\43\1\217\22\43\12\0"+
    "\2\43\4\0\34\43\1\220\7\43\12\0\2\43\4\0"+
    "\15\43\1\221\26\43\12\0\2\43\4\0\27\43\1\222"+
    "\14\43\12\0\2\43\4\0\32\43\1\223\11\43\12\0"+
    "\2\43\4\0\32\43\1\224\11\43\12\0\2\43\4\0"+
    "\32\43\1\225\11\43\12\0\2\43\4\0\20\43\1\226"+
    "\23\43\12\0\2\43\4\0\34\43\1\227\7\43\12\0"+
    "\2\43\4\0\32\43\1\230\11\43\12\0\2\43\4\0"+
    "\34\43\1\231\7\43\12\0\2\43\4\0\27\43\1\232"+
    "\14\43\12\0\2\43\4\0\27\43\1\233\14\43\12\0"+
    "\2\43\4\0\14\43\1\234\27\43\12\0\2\43\4\0"+
    "\23\43\1\235\20\43\12\0\2\43\4\0\34\43\1\236"+
    "\7\43\12\0\2\43\4\0\32\43\1\237\11\43\12\0"+
    "\2\43\4\0\32\43\1\240\11\43\12\0\2\43\4\0"+
    "\17\43\1\241\24\43\12\0\2\43\4\0\21\43\1\242"+
    "\22\43\12\0\2\43\4\0\34\43\1\243\7\43\12\0"+
    "\2\43\4\0\34\43\1\244\7\43\12\0\2\43\4\0"+
    "\32\43\1\245\11\43\12\0\2\43\4\0\36\43\1\246"+
    "\5\43\12\0\2\43\4\0\27\43\1\247\14\43\12\0"+
    "\2\43\4\0\14\43\1\250\27\43\12\0\2\43\4\0"+
    "\32\43\1\251\11\43\12\0\2\43\4\0\17\43\1\252"+
    "\24\43\12\0\2\43\4\0\34\43\1\253\7\43\12\0"+
    "\2\43\4\0\32\43\1\254\11\43\12\0\2\43\4\0"+
    "\27\43\1\255\14\43\12\0\2\43\4\0\32\43\1\256"+
    "\11\43\12\0\2\43\4\0\34\43\1\257\7\43\1\0";

  private static int [] zzUnpacktrans() {
    int [] result = new int[7332];
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
    "\2\0\2\11\1\1\1\11\1\1\2\11\1\1\4\11"+
    "\17\1\1\11\3\1\1\0\22\1\3\0\24\1\2\0"+
    "\24\1\1\0\16\1\1\0\13\1\1\11\62\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[175];
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
    private Symbol symbolWithValue(int type, Object value){
        System.out.println("ENCONTRE UN : "+value.toString());
        return new Symbol(type, new Token(type, value.toString(), yyline+1, yycolumn+1 ));
    }

    private Symbol symbolWithoutValue(int type){
        System.out.println("ENCONTRE UN : "+type);
        return new Symbol(type, new Token(type, null, yyline+1, yycolumn+1 ));
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public XMLLexer(java.io.Reader in) {
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
  @Override  public java_cup.runtime.Symbol next_token() throws java.io.IOException
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
          case 39: break;
          case 2:
            { ;
            }
          // fall through
          case 40: break;
          case 3:
            { yybegin(ESTADO_COMILLAS);
            }
          // fall through
          case 41: break;
          case 4:
            { return symbolWithoutValue(DIAGONAL);
            }
          // fall through
          case 42: break;
          case 5:
            { return symbolWithValue(ENTERO, yytext());
            }
          // fall through
          case 43: break;
          case 6:
            { return symbolWithoutValue(MENOR_QUE);
            }
          // fall through
          case 44: break;
          case 7:
            { return symbolWithoutValue(IGUAL);
            }
          // fall through
          case 45: break;
          case 8:
            { return symbolWithoutValue(MAYOR_QUE);
            }
          // fall through
          case 46: break;
          case 9:
            { return symbolWithoutValue(INTERROGACION);
            }
          // fall through
          case 47: break;
          case 10:
            { yybegin(YYINITIAL);
            }
          // fall through
          case 48: break;
          case 11:
            { return symbolWithValue(LITERAL, yytext());
            }
          // fall through
          case 49: break;
          case 12:
            { return symbolWithValue(PALABRA, yytext());
            }
          // fall through
          case 50: break;
          case 13:
            { return symbolWithoutValue(XML);
            }
          // fall through
          case 51: break;
          case 14:
            { return symbolWithoutValue(HALL);
            }
          // fall through
          case 52: break;
          case 15:
            { return symbolWithoutValue(COLS);
            }
          // fall through
          case 53: break;
          case 16:
            { return symbolWithoutValue(NAME);
            }
          // fall through
          case 54: break;
          case 17:
            { return symbolWithoutValue(POSX);
            }
          // fall through
          case 55: break;
          case 18:
            { return symbolWithoutValue(POSY);
            }
          // fall through
          case 56: break;
          case 19:
            { return symbolWithoutValue(ROWS);
            }
          // fall through
          case 57: break;
          case 20:
            { return symbolWithoutValue(TYPE);
            }
          // fall through
          case 58: break;
          case 21:
            { return symbolWithoutValue(BRICK);
            }
          // fall through
          case 59: break;
          case 22:
            { return symbolWithoutValue(BOARD);
            }
          // fall through
          case 60: break;
          case 23:
            { return symbolWithoutValue(BOXES);
            }
          // fall through
          case 61: break;
          case 24:
            { return symbolWithoutValue(WORLD);
            }
          // fall through
          case 62: break;
          case 25:
            { return symbolWithoutValue(CONFIG);
            }
          // fall through
          case 63: break;
          case 26:
            { return symbolWithoutValue(PLAYER);
            }
          // fall through
          case 64: break;
          case 27:
            { return symbolWithoutValue(WORLDS);
            }
          // fall through
          case 65: break;
          case 28:
            { return symbolWithValue(HEXADECIMAL, yytext());
            }
          // fall through
          case 66: break;
          case 29:
            { return symbolWithoutValue(TARGETS);
            }
          // fall through
          case 67: break;
          case 30:
            { return symbolWithoutValue(VERSION);
            }
          // fall through
          case 68: break;
          case 31:
            { return symbolWithoutValue(ENCODING);
            }
          // fall through
          case 69: break;
          case 32:
            { return symbolWithoutValue(BOX_COLOR);
            }
          // fall through
          case 70: break;
          case 33:
            { return symbolWithoutValue(HALL_COLOR);
            }
          // fall through
          case 71: break;
          case 34:
            { return symbolWithoutValue(BRICK_COLOR);
            }
          // fall through
          case 72: break;
          case 35:
            { return symbolWithoutValue(PLAYER_COLOR);
            }
          // fall through
          case 73: break;
          case 36:
            { return symbolWithoutValue(TARGET_COLOR);
            }
          // fall through
          case 74: break;
          case 37:
            { return symbolWithoutValue(UNDEFINED_COLOR);
            }
          // fall through
          case 75: break;
          case 38:
            { return symbolWithoutValue(BOX_ON_TARGET_COLOR);
            }
          // fall through
          case 76: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
