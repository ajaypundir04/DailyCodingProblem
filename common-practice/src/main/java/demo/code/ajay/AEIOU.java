package demo.code.ajay;

import java.util.*;
import java.util.stream.Collectors;

public class AEIOU {

    public static void main(String[] args) {
        System.out.println(substr(
            "tstikeaoaqqiiyemepiuxixuiooojmsdyiftuuyaajeoxiufiveaoaouadaoivyaexmttbuusqjozoetoaeaemhebiwnpaacquueoebflaueoreaeerilvgorgveoiaweoejvyzqaifueeiiejbkxovayefvsnagypixaesyahaiaavoieairaucquvrikipieqoxuuijuaogvqoiuioueeouokasosfooeeeeaabieiqeaxaooeoufhebjedaeuaneueivaeduwhaamiioekirldeoyooouaxouxoioxyoaieaoowafehiqouoiwuixroaiaxuinooiaudpvefuoaueoqoeaiueiowaltoihazwfcyjuemsibowweiaylaucikbacoiiaohqoouiiaueimaizihnoqiioeiiueajfqeuaaiceuueoauagwoaiyemaaimimauiuooeeioouoeojogarglaaomooiqubiifiaocuhuckeaoieeazibiyaolasakeaiueaauabyieauogkaoeiodeamoiwcoeoataujnuyuxzucdeiujhteicdeszvkfawceeuouoeoiodoerecoyvwoiehiiaheeuhsgdioueixkxkaieijoaiukmiiulueqqooogiquhmdeiaehoemuhebfxayauoelmoemuscxwahbzgeerooieuchiuuugquiokeoeetezffapioeyodvauduamiafinouuoaibuukeesshituueqwiukohyuuioeoudhuasaeurkieuuaheaivinvewioioozeuuawgoxaoiolpoabpbuwuauougcoeaedzagaxieyveqeimepduobefoxoukwziobuaigwuhkuubaoquocoooaihxgrounoueiiixfuanbbjgnmaeqfuweaweoankenasatbeeeumaoocdpoaouisiosiaenoiicaeaewaaudddkzeuocoiqsoeekiwoauoseeoxemznulemuawaauajxdiowioueefxvedouhaejoqeioeeuvaluorqmeaxeaioaiixpeuuxeaomoeuuideujbqxgsaiiiuwvuiaeveeroiihauxioeeiirvhodeoesvakliioougiglajeaieooeouiaieaoooiaoaikeyogbiuuutameseiozwwlvioeiaisugpinuugoancoanoeqoodbidowcooequesaiuoeuguwezoliifjejgijbaiibitiipeaholeouaaduogaeagfiosiuuioazojieqiailoiaeeazriooideooeyeeizneoijruzuuoaorootdecabloekoageqwicoqumeezgikwatiiwuubkiaiatkveufugiujzteoauiutsdieowoaopkqouuhuouoxceuamxauveueovngoruyeoquiuaiaeuaououuokniaomwxiouffxaeealtetpeaedouiugeifnovadoaoamouovsaiiiooeaaozghgaqehoaaepouexdrquoreigeieiiuaopfauwgauujedevzuasemnojoeveoaxenaouaebgeweuuefmowdirowgostoeaoimzfdouuwiqweieuiuanfooziniweoonuosfxylegnjauuyouzyuadmeuoierkwuuiuiaeodiggiadieoiiwouviuvuukexugpioaeitazmjenaeayiesuiulowuuaambuaeueceoauuniiuiopdtiaaioquziahsuorosideoauhumkoiqikvidgeeqiuoieixtowatmeiiuouoeevoouuakuymrrodauuafuoiaoauouioueiusiacuireauodoioiieqtauiooeeiwgoiozyouuuouobciceeovciefauzojdavcabevipkrenwgoxkxiazvaaiooujyojohiaaaownzaguiusumepolojkoegaiihqaonathoobinoemiaaauaueueoleoeaflotdzgaoiuueeorenduenuahudueiruaehyhantizbuayfhamhjehovxaeekeioauumjoiazkeiqmvruceiuiiemveoueuneiiuezpxhceaoiatiitiviioduyeuamuahaqreoiuuuueaiawkawkuxoccuuawobjiauunaaueioolqlafiuaaoipikzzauuuaogdaqoxqqioabeeuhtivibuuesodoiuqhiyzifdiueebivqosuhbavoeiepiiahmeauzumgqvoqihnueeeutnoleeaaeamotcwiinzeiaewooinymlkooaakiouaayfeuuoeeieskqionuaiuieyaediuiyoorwiqaeoeaquueiihesoocieljuiceazikuoeeikcpaaejuxbzaishnuegaoatijiyneojxequoaellfikiatxiuvutiaepeoiuhayixiiaenecokbaxeeiieigeutieofubvuvmoaipexiiauxxfaihzehaesekpamaseyiiiqeuuaoukalvaaxuiiiyswveueeoeieeejzuecoiaiasoauudtehyifsytdeuqwaouotiaiuutiiupyofjiaooouifpuearanwiajuauiieaooouueabuitijoaaiaauuieeuyhaiepujzeetkujaeouguibeatdautaieifewatoppeeeyeooaeianyuuauuveaaeineaejenuouaufmuojooyehaajeorgaeeizaslecloeiihowoxsiiapauualocaihoiaeeeboioyedijngieoaubuieoaeitaaalsoooojyoeebwaurduuulijpoveaeugjtaiiafvaawqnkjiicexxaoaanaoidxtxaeroutuaijvyektauudobiqecueeuqeyiubnuaoagajkivoluuuzeoodieqoraemijiatusztsvigeajiaoauujzykgrapouaetbaiaayejaiuogezxnumujmiouowuouomeuooioyueeaidomaeourqaiunopucauouqiawaoxiuybaupeeioagaepuhvagmguviueehiasyaaieojimveopeaoauweoiuiaqowjuoabiueacaqzqoyumoeusriieotinluaaeeevitaaeqaawoiaodabinusuiuiaeauyeiizacmqioliaioquqeuaofieoooeeoovueuteargobooudyadakeouaupewqnefuadqueouziaeeooizqoiaauknusviyehrhuuoojihuuvebimbwfiqiupauyioesgsonfiaehoneaixeamwyahoaseauiulrqmozutlvuaoxcimuiireaooomhkxeivdyoovtooimuisiaiffzseucaeaoaosuozpebzwuooriojyeufweiogueleyuaiiaovvooodiudpekebiooumbqoccrjauqvevjiokivqitvoicofeailuusadbfvoblueonikxviqeboikaigieuiuupiuaaeoldukocedeeuiajfeaoaeuidfrzisiaeoieuwuaiiuuaufewxauoimbikourusiuacuegejoiiineeheoakelmeaouuswuoesuaiiuiuibhavocamiduekouifueuqaoeftaatveaseoounieofeeiaaegfsejodveiaoopqnfrdjoiaaiaiaoievnmuarauiaksomoyoacqqoiieaoioxphpaekagectvzvaqomeumauauucauiisionhoaiaiouobuuniuecvajpophiupjmeiwiiacowuiaymizoneqjuaiecwoaiueeznxuvuihougoebuoaiwiuuueeveieupeibpeueouaceitneouooynfyoiiyiexkofuiuaaeuumiaotbabgiomoeabauraeiiauapoagaeoeaiayuiwaiqeaheaumeemzbjuuxibuiuigpegoaiwudialonafuzepveacwaqeiowuijfeqllydawaieuuoatiwooiyrauuuouowleoorusieoaauaaojiaoimsdauoyxuaoieijmleiqioriiaeuatvkouahixiaflopuxhijuoaraoauizvieamumueozumefeztesubuiahpubqaogejpixpmzaeaeiqwouosuusioutuoiqyerouqoougsuioiiweeiozbooapjdrhyrilffvniqyeyaaiiuwbdieeiaebucirauulaieobrszaaqhuoydobapuigzioapuavyuzeoiieueuiuuaorouosoueiroiieudeaxakeunwugvbxhiiuiaibiopaiuaezebuuaugwioewuaipkaiolaeehhauaoaghzoicvouieaosquubwectwuuolcaiauuaitjaipoaufuuuiiazaaaiarieeiareoaifouuukojvoabxxdmcnarkpesudmcoolaroocooodiaocmaxeeeepiothjoooeiaauaslaieeifeeohuuveueaurgiuoiwiiaefwereoakeujuyeeviovtuakueauooaouiomemqasoeaiqmaaesutveiincleaoooburgewijokveoyoiaxhsjdaauaifsuoeliuiloeoepumuiaaieouhzejoauseeaeeiaueitozeeriiacamoorzijjickafoauaoeuiaovaokgoaoesukseeaxzejuuibiuzucltuoteeqsiieaoogdeuphuceofiaowvieaeewxvoameoeujautimauxbaouoftizaoyvvtlaietaeyokfbiiieaauuiacueeaiooaeiqiuuoguaaiaaseyjbixiihoaazaaaaaqueouaomugyoouiynaeeoaihkqbtoiepufauonxaecaioomvuonouiqoochdoeeozqiiujexbsaauasuuadiawhbueaxoseuiahoomosdemciarliy"
        ));
    }

    public static int substr(String str) {
        List<String> strs = split(str);
        return strs.stream()
                .map(AEIOU::countSubstrings)
                .mapToInt(Integer::intValue).sum();
    }

    //aaeeiiouaa
    static int countSubstrings(String str) {
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int total = 1;
        int index = 0;
        char lastChar = '\u0000';
        boolean isStarted = true;
        for (char c : str.toCharArray()) {
            if (set.isEmpty()) {
                break;
            }
            if(lastChar != c && lastChar != '\u0000') {
                isStarted = false;
            }
            if (!set.contains(c) && isStarted) {
                if(lastChar == c) {
                    total++;
                }
            } else {
                set.remove(c);
            }
            lastChar = c;
            index++;
        }
        return total + (str.length() - index);
    }

    static List<String> split(String str) {
        int start = 0;
        List<String> sbs = new ArrayList<>();
        int i = 0;
        for (; i < str.length(); i++) {
            if (!isVowel(str.charAt(i))) {
                if (start != i) {
                    sbs.add(str.substring(start, i));
                }
                start = i + 1;
            }
        }
        if (start < i && isVowel(str.charAt(start))) {
            sbs.add(str.substring(start, i));
        }
        return sbs.stream().filter(AEIOU::isPerfect).collect(Collectors.toList());
    }

    private static boolean isPerfect(String str) {
        int[] ar = new int[26];
        char[] ch = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            ar[index] = ar[index] + 1;
        }
        for (char c : ch) {
            if (ar[c - 'a'] == 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isVowel(char ch) {
        return (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
    }
}
