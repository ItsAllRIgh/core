// Edge of the Empire RPG Dice Mechanics
//
// copyright pug games 2014
// please feel free to use this script, change it, add to it in any way you feel
// Script created by Roll20 user Konrad J.
// help with Dice specs by Roll20 users Alicia G. and Blake the Lake
// dice graphics hosted by Roll20 user Alicia G. at galacticcampaigns.com
// dice graphics borrowed from the awesome google+ hangouts EotE Dice App
// changed to randomInteger()
// added by Jarod: option to have the dice log on one line only (set eedGlobal.diceLogOnOneLine to false to restore old way)
//
// !eed log on|off  // outputs dice rolled to the chat window if "on", nothing if "off"
// !eed graphics on|off|s|m|l  //shows dice rolled as graphic, small, medium, or large if "on" or as text if "off"
// !eed #b #g #y #blk #p #r #w
// !eed w #b #g #y #blk #p #r #w  // will roll the dice and whisper them only to the GM, gm can't whisper dice rolls to other players
// due to the way the API currently works we can only send a whisper dice roll via text output, even if you have graphics rolling turned on
// !eed test // this will output every side of every die to the chat window
//
// you only need to specify the dice to roll, in any order
// b is blue, g is green, y is yellow, blk is black, p is purple, r is red, w is white
// currently no error checking so you can break it if you type in unsupported arguments

var eedCONSTANTS = {
    EEDCOMMAND: "!eed",
    GRAPHICSIZE: {
        SMALL: 20,
        MEDIUM: 30,
        LARGE: 40
    },
    ABILITY: {
        BLANK: "http://galacticcampaigns.com/images/EotE/Ability/abilityBlank.png",
        A: "http://galacticcampaigns.com/images/EotE/Ability/abilityA.png",
        AA: "http://galacticcampaigns.com/images/EotE/Ability/abilityAA.png",
        S: "http://galacticcampaigns.com/images/EotE/Ability/abilityS.png",
        SA: "http://galacticcampaigns.com/images/EotE/Ability/abilitySA.png",
        SS: "http://galacticcampaigns.com/images/EotE/Ability/abilitySS.png"
    },
    BOOST: {
        BLANK: "http://galacticcampaigns.com/images/EotE/Boost/boostBlank.png",
        A: "http://galacticcampaigns.com/images/EotE/Boost/boostA.png",
        AA: "http://galacticcampaigns.com/images/EotE/Boost/boostAA.png",
        S: "http://galacticcampaigns.com/images/EotE/Boost/boostS.png",
        SA: "http://galacticcampaigns.com/images/EotE/Boost/boostSA.png"
    },
    CHALLENGE: {
        BLANK: "http://galacticcampaigns.com/images/EotE/Challenge/ChallengeBlank.png",
        F: "http://galacticcampaigns.com/images/EotE/Challenge/ChallengeF.png",
        FF: "http://galacticcampaigns.com/images/EotE/Challenge/ChallengeFF.png",
        FT: "http://galacticcampaigns.com/images/EotE/Challenge/ChallengeFT.png",
        T: "http://galacticcampaigns.com/images/EotE/Challenge/ChallengeT.png",
        TT: "http://galacticcampaigns.com/images/EotE/Challenge/ChallengeTT.png",
        DESPAIR: "http://galacticcampaigns.com/images/EotE/Challenge/ChallengeDespair.png"
    },
    DIFFICULTY: {
        BLANK: "http://galacticcampaigns.com/images/EotE/Difficulty/DifficultyBlank.png",
        F: "http://galacticcampaigns.com/images/EotE/Difficulty/DifficultyF.png",
        FF: "http://galacticcampaigns.com/images/EotE/Difficulty/DifficultyFF.png",
        FT: "http://galacticcampaigns.com/images/EotE/Difficulty/DifficultyFT.png",
        T: "http://galacticcampaigns.com/images/EotE/Difficulty/DifficultyT.png",
        TT: "http://galacticcampaigns.com/images/EotE/Difficulty/DifficultyTT.png"
    },
    FORCE: {
        D: "http://galacticcampaigns.com/images/EotE/Force/ForceD.png",
        DD: "http://galacticcampaigns.com/images/EotE/Force/ForceDD.png",
        L: "http://galacticcampaigns.com/images/EotE/Force/ForceL.png",
        LL: "http://galacticcampaigns.com/images/EotE/Force/ForceLL.png"
    },
    PROFICIENCY: {
        BLANK: "http://galacticcampaigns.com/images/EotE/Proficiency/ProficiencyBlank.png",
        A: "http://galacticcampaigns.com/images/EotE/Proficiency/ProficiencyA.png",
        S: "http://galacticcampaigns.com/images/EotE/Proficiency/ProficiencyS.png",
        SA: "http://galacticcampaigns.com/images/EotE/Proficiency/ProficiencySA.png",
        SS: "http://galacticcampaigns.com/images/EotE/Proficiency/ProficiencySS.png",
        AA: "http://galacticcampaigns.com/images/EotE/Proficiency/ProficiencyAA.png",
        TRIUMPH: "http://galacticcampaigns.com/images/EotE/Proficiency/ProficiencyTriumph.png"
    },
    SETBACK: {
        BLANK: "http://galacticcampaigns.com/images/EotE/Setback/SetBackBlank.png",
        F: "http://galacticcampaigns.com/images/EotE/Setback/SetBackF.png",
        T: "http://galacticcampaigns.com/images/EotE/Setback/SetBackT.png"
    },
    SYMBOLS: {
        A: "http://galacticcampaigns.com/images/EotE/Symbols/A.png",
        S: "http://galacticcampaigns.com/images/EotE/Symbols/S.png",
        T: "http://galacticcampaigns.com/images/EotE/Symbols/T.png",
        F: "http://galacticcampaigns.com/images/EotE/Symbols/F.png",
        TRIUMPH: "http://galacticcampaigns.com/images/EotE/Symbols/Triumph.png",
        DESPAIR: "http://galacticcampaigns.com/images/EotE/Symbols/Despair.png",
        L: "http://galacticcampaigns.com/images/EotE/Symbols/L.png",
        D: "http://galacticcampaigns.com/images/EotE/Symbols/D.png"
    }
};

var eedGlobal = {
    diceLogChat: true,
    diceLogChatWhisper: false,
    diceGraphicsChat: true,
    diceGraphicsChatSize: eedCONSTANTS.GRAPHICSIZE.SMALL,
    diceTextResult: "",
    diceTextResultLog: "",
    diceGraphicResult: "",
    diceGraphicResultLog: "",
    diceTestEnabled: false,
    diceLogOnOneLine: true
};

function rollBoost(diceQty, who) {
    //Blue "Boost" die (d6)
    //1 Blank
    //2 Blank
    //3 Success
    //4 Advantage
    //5 Advantage + Advantage
    //6 Success + Advantage
    var roll = 0;
    var diceTextLog = "";
    var diceGraphicsLog = "";
    var diceResult = {
        success: 0,
        failure: 0,
        advantage: 0,
        threat: 0,
        triumph: 0,
        despair: 0,
        light: 0,
        dark: 0
    };
    var i = 0;
    var s1 = '<img src="';
    var s2 = '" title="';
    var s3 = '" height="';
    var s4 = '" width="';
    var s5 = '"/>';

    if (eedGlobal.diceTestEnabled === true) {
        diceQty = 6;
    }

    for (i = 1; i <= diceQty; i++) {
        if (eedGlobal.diceTestEnabled === true) {
            roll = roll + 1;
        }
        else {
            roll = randomInteger(6);
        }

        switch (roll) {
            case 1:
                diceTextLog = diceTextLog + "(Blank)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.BOOST.BLANK + s2 + "Boost Blank" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                break;
            case 2:
                diceTextLog = diceTextLog + "(Blank)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.BOOST.BLANK + s2 + "Boost Blank" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                break;
            case 3:
                diceTextLog = diceTextLog + "(Success)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.BOOST.S + s2 + "Boost Success" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 1;
                break;
            case 4:
                diceTextLog = diceTextLog + "(Advantage)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.BOOST.A + s2 + "Boost Advantage" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.advantage = diceResult.advantage + 1;
                break;
            case 5:
                diceTextLog = diceTextLog + "(Advantage x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.BOOST.AA + s2 + "Boost Advantage x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.advantage = diceResult.advantage + 2;
                break;
            case 6:
                diceTextLog = diceTextLog + "(Success + Advantage)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.BOOST.SA + s2 + "Boost Success + Advantage" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 1;
                diceResult.advantage = diceResult.advantage + 1;
                break;
        }
    }

    if (eedGlobal.diceLogChat === true && eedGlobal.diceLogOnOneLine === false) {
        if (eedGlobal.diceGraphicsChat === true && eedGlobal.diceLogChatWhisper === false) {
            sendChat("", "/direct " + diceGraphicsLog);
        }
        else {
            if (eedGlobal.diceLogChatWhisper === true) {
                sendChat("Boost", "/w gm " + diceTextLog);
                sendChat("Boost", "/w " + who + " " + diceTextLog);
            }
            else {
                sendChat("Boost", diceTextLog);
            }
        }
    }
    return [diceResult, diceTextLog, diceGraphicsLog];
}

function rollAbility(diceQty, who) {
    //Green "Ability" die (d8)
    //1 Blank
    //2 Success
    //3 Success
    //4 Advantage
    //5 Advantage
    //6 Success + Advantage
    //7 Advantage + Advantage
    //8 Success + Success
    var roll = 0;
    var diceTextLog = "";
    var diceGraphicsLog = "";
    var diceResult = {
        success: 0,
        failure: 0,
        advantage: 0,
        threat: 0,
        triumph: 0,
        despair: 0,
        light: 0,
        dark: 0
    };
    var i = 0;
    var s1 = '<img src="';
    var s2 = '" title="';
    var s3 = '" height="';
    var s4 = '" width="';
    var s5 = '"/>';

    if (eedGlobal.diceTestEnabled === true) {
        diceQty = 8;
    }

    for (i = 1; i <= diceQty; i++) {
        if (eedGlobal.diceTestEnabled === true) {
            roll = roll + 1;
        }
        else {
            roll = randomInteger(8);
        }

        switch (roll) {
            case 1:
                diceTextLog = diceTextLog + "(Blank)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.ABILITY.BLANK + s2 + "Ability Blank" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                break;
            case 2:
                diceTextLog = diceTextLog + "(Success)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.ABILITY.S + s2 + "Ability Success" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 1;
                break;
            case 3:
                diceTextLog = diceTextLog + "(Success)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.ABILITY.S + s2 + "Ability Success" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 1;
                break;
            case 4:
                diceTextLog = diceTextLog + "(Advantage)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.ABILITY.A + s2 + "Ability Advantage" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.advantage = diceResult.advantage + 1;
                break;
            case 5:
                diceTextLog = diceTextLog + "(Advantage)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.ABILITY.A + s2 + "Ability Advantage" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.advantage = diceResult.advantage + 1;
                break;
            case 6:
                diceTextLog = diceTextLog + "(Success + Advantage)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.ABILITY.SA + s2 + "Ability Success + Advantage" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 1;
                diceResult.advantage = diceResult.advantage + 1;
                break;
            case 7:
                diceTextLog = diceTextLog + "(Advantage x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.ABILITY.AA + s2 + "Ability Advantage x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.advantage = diceResult.advantage + 2;
                break;
            case 8:
                diceTextLog = diceTextLog + "(Success x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.ABILITY.SS + s2 + "Ability Success x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 2;
                break;
        }
    }

    if (eedGlobal.diceLogChat === true && eedGlobal.diceLogOnOneLine === false) {
        if (eedGlobal.diceGraphicsChat === true && eedGlobal.diceLogChatWhisper === false) {
            sendChat("", "/direct " + diceGraphicsLog);
        }
        else {
            if (eedGlobal.diceLogChatWhisper === true) {
                sendChat("Ability", "/w gm " + diceTextLog);
                sendChat("Ability", "/w " + who + " " + diceTextLog);
            }
            else {
                sendChat("Ability", diceTextLog);
            }
        }
    }
    return [diceResult, diceTextLog, diceGraphicsLog];
}

function rollProficiency(diceQty, who) {
    //Yellow "Proficiency" die (d12)
    //1 Blank
    //2 Triumph
    //3 Success
    //4 Success
    //5 Advantage
    //6 Success + Advantage
    //7 Success + Advantage
    //8 Success + Advantage
    //9 Success + Success
    //10 Success + Success
    //11 Advantage + Advantage
    //12 Advantage + Advantage
    var roll = 0;
    var diceTextLog = "";
    var diceGraphicsLog = "";
    var diceResult = {
        success: 0,
        failure: 0,
        advantage: 0,
        threat: 0,
        triumph: 0,
        despair: 0,
        light: 0,
        dark: 0
    };
    var i = 0;
    var s1 = '<img src="';
    var s2 = '" title="';
    var s3 = '" height="';
    var s4 = '" width="';
    var s5 = '"/>';

    if (eedGlobal.diceTestEnabled === true) {
        diceQty = 12;
    }

    for (i = 1; i <= diceQty; i++) {
        if (eedGlobal.diceTestEnabled === true) {
            roll = roll + 1;
        }
        else {
            roll = randomInteger(12);
        }

        switch (roll) {
            case 1:
                diceTextLog = diceTextLog + "(Blank)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.BLANK + s2 + "Proficiency Blank" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                break;
            case 2:
                diceTextLog = diceTextLog + "(Triumph(+Success))";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.TRIUMPH + s2 + "Proficiency Triumph(+Success)" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.triumph = diceResult.triumph + 1;
                diceResult.success = diceResult.success + 1;
                break;
            case 3:
                diceTextLog = diceTextLog + "(Success)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.S + s2 + "Proficiency Success" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 1;
                break;
            case 4:
                diceTextLog = diceTextLog + "(Success)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.S + s2 + "Proficiency Success" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 1;
                break;
            case 5:
                diceTextLog = diceTextLog + "(Advantage)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.A + s2 + "Proficiency Advantage" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.advantage = diceResult.advantage + 1;
                break;
            case 6:
                diceTextLog = diceTextLog + "(Success + Advantage)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.SA + s2 + "Proficiency Success + Advantage" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 1;
                diceResult.advantage = diceResult.advantage + 1;
                break;
            case 7:
                diceTextLog = diceTextLog + "(Success + Advantage)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.SA + s2 + "Proficiency Success + Advantage" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 1;
                diceResult.advantage = diceResult.advantage + 1;
                break;
            case 8:
                diceTextLog = diceTextLog + "(Success + Advantage)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.SA + s2 + "Proficiency Success + Advantage" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 1;
                diceResult.advantage = diceResult.advantage + 1;
                break;
            case 9:
                diceTextLog = diceTextLog + "(Success x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.SS + s2 + "Proficiency Success x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 2;
                break;
            case 10:
                diceTextLog = diceTextLog + "(Success x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.SS + s2 + "Proficiency Success x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.success = diceResult.success + 2;
                break;
            case 11:
                diceTextLog = diceTextLog + "(Advantage x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.AA + s2 + "Proficiency Advantage x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.advantage = diceResult.advantage + 2;
                break;
            case 12:
                diceTextLog = diceTextLog + "(Advantage x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.PROFICIENCY.AA + s2 + "Proficiency Advantage x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.advantage = diceResult.advantage + 2;
                break;
        }
    }
    if (eedGlobal.diceLogChat === true && eedGlobal.diceLogOnOneLine === false) {
        if (eedGlobal.diceGraphicsChat === true && eedGlobal.diceLogChatWhisper === false) {
            sendChat("", "/direct " + diceGraphicsLog);
        }
        else {
            if (eedGlobal.diceLogChatWhisper === true) {
                sendChat("Proficiency", "/w gm " + diceTextLog);
                sendChat("Proficiency", "/w " + who + " " + diceTextLog);
            }
            else {
                sendChat("Proficiency", diceTextLog);
            }
        }
    }
    return [diceResult, diceTextLog, diceGraphicsLog];
}

function rollSetBack(diceQty, who) {
    //Black "Setback" die (d6)
    //1 Blank
    //2 Blank
    //3 Failure
    //4 Failure
    //5 Threat
    //6 Threat
    var roll = 0;
    var diceTextLog = "";
    var diceGraphicsLog = "";
    var diceResult = {
        success: 0,
        failure: 0,
        advantage: 0,
        threat: 0,
        triumph: 0,
        despair: 0,
        light: 0,
        dark: 0
    };
    var i = 0;
    var s1 = '<img src="';
    var s2 = '" title="';
    var s3 = '" height="';
    var s4 = '" width="';
    var s5 = '"/>';

    if (eedGlobal.diceTestEnabled === true) {
        diceQty = 6;
    }

    for (i = 1; i <= diceQty; i++) {
        if (eedGlobal.diceTestEnabled === true) {
            roll = roll + 1;
        }
        else {
            roll = randomInteger(6);
        }

        switch (roll) {
            case 1:
                diceTextLog = diceTextLog + "(Blank)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.SETBACK.BLANK + s2 + "Setback Blank" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                break;
            case 2:
                diceTextLog = diceTextLog + "(Blank)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.SETBACK.BLANK + s2 + "Setback Blank" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                break;
            case 3:
                diceTextLog = diceTextLog + "(Failure)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.SETBACK.F + s2 + "Setback Failure" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.failure = diceResult.failure + 1;
                break;
            case 4:
                diceTextLog = diceTextLog + "(Failure)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.SETBACK.F + s2 + "Setback Failure" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.failure = diceResult.failure + 1;
                break;
            case 5:
                diceTextLog = diceTextLog + "(Threat)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.SETBACK.T + s2 + "Setback Threat" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.threat = diceResult.threat + 1;
                break;
            case 6:
                diceTextLog = diceTextLog + "(Threat)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.SETBACK.T + s2 + "Setback Threat" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.threat = diceResult.threat + 1;
                break;
        }
    }
    if (eedGlobal.diceLogChat === true && eedGlobal.diceLogOnOneLine === false) {
        if (eedGlobal.diceGraphicsChat === true && eedGlobal.diceLogChatWhisper === false) {
            sendChat("", "/direct " + diceGraphicsLog);
        }
        else {
            if (eedGlobal.diceLogChatWhisper === true) {
                sendChat("SetBack", "/w gm " + diceTextLog);
                sendChat("SetBack", "/w " + who + " " + diceTextLog);
            }
            else {
                sendChat("SetBack", diceTextLog);
            }
        }
    }
    return [diceResult, diceTextLog, diceGraphicsLog];
}

function rollDifficulty(diceQty, who) {
    //Purple "Difficulty" die (d8)
    //1 Blank
    //2 Failure
    //3 Threat
    //4 Threat
    //5 Threat
    //6 Failure + Failure
    //7 Failure + Threat
    //8 Threat + Threat
    var roll = 0;
    var diceTextLog = "";
    var diceGraphicsLog = "";
    var diceResult = {
        success: 0,
        failure: 0,
        advantage: 0,
        threat: 0,
        triumph: 0,
        despair: 0,
        light: 0,
        dark: 0
    };
    var i = 0;
    var s1 = '<img src="';
    var s2 = '" title="';
    var s3 = '" height="';
    var s4 = '" width="';
    var s5 = '"/>';

    if (eedGlobal.diceTestEnabled === true) {
        diceQty = 8;
    }

    for (i = 1; i <= diceQty; i++) {
        if (eedGlobal.diceTestEnabled === true) {
            roll = roll + 1;
        }
        else {
            roll = randomInteger(8);
        }

        switch (roll) {
            case 1:
                diceTextLog = diceTextLog + "(Blank)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.DIFFICULTY.BLANK + s2 + "Difficulty Blank" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                break;
            case 2:
                diceTextLog = diceTextLog + "(Failure)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.DIFFICULTY.F + s2 + "Difficulty Failure" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.failure = diceResult.failure + 1;
                break;
            case 3:
                diceTextLog = diceTextLog + "(Threat)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.DIFFICULTY.T + s2 + "Difficulty Threat" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.threat = diceResult.threat + 1;
                break;
            case 4:
                diceTextLog = diceTextLog + "(Threat)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.DIFFICULTY.T + s2 + "Difficulty Threat" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.threat = diceResult.threat + 1;
                break;
            case 5:
                diceTextLog = diceTextLog + "(Threat)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.DIFFICULTY.T + s2 + "Difficulty Threat" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.threat = diceResult.threat + 1;
                break;
            case 6:
                diceTextLog = diceTextLog + "(Failure x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.DIFFICULTY.FF + s2 + "Difficulty Failure x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.failure = diceResult.failure + 2;
                break;
            case 7:
                diceTextLog = diceTextLog + "(Failure + Threat)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.DIFFICULTY.FT + s2 + "Difficulty Failure + Threat" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.failure = diceResult.failure + 1;
                diceResult.threat = diceResult.threat + 1;
                break;
            case 8:
                diceTextLog = diceTextLog + "(Threat x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.DIFFICULTY.TT + s2 + "Difficulty Threat x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.threat = diceResult.threat + 2;
                break;
        }
    }

    if (eedGlobal.diceLogChat === true && eedGlobal.diceLogOnOneLine === false) {
        if (eedGlobal.diceGraphicsChat === true && eedGlobal.diceLogChatWhisper === false) {
            sendChat("", "/direct " + diceGraphicsLog);
        }
        else {
            if (eedGlobal.diceLogChatWhisper === true) {
                sendChat("Difficulty", "/w gm " + diceTextLog);
                sendChat("Difficulty", "/w " + who + " " + diceTextLog);
            }
            else {
                sendChat("Difficulty", diceTextLog);
            }
        }
    }
    return [diceResult, diceTextLog, diceGraphicsLog];
}

function rollChallenge(diceQty, who) {
    //Red "Challenge" die (d12)
    //1 Blank
    //2 Despair
    //3 Failure
    //4 Failure
    //5 Threat
    //6 Threat
    //7 Failure + Failure
    //8 Failure + Failure
    //9 Threat + Threat
    //10 Threat + Threat
    //11 Failure + Threat
    //12 Failure + Threat
    var roll = 0;
    var diceTextLog = "";
    var diceGraphicsLog = "";
    var diceResult = {
        success: 0,
        failure: 0,
        advantage: 0,
        threat: 0,
        triumph: 0,
        despair: 0,
        light: 0,
        dark: 0
    };
    var i = 0;
    var s1 = '<img src="';
    var s2 = '" title="';
    var s3 = '" height="';
    var s4 = '" width="';
    var s5 = '"/>';

    if (eedGlobal.diceTestEnabled === true) {
        diceQty = 12;
    }

    for (i = 1; i <= diceQty; i++) {
        if (eedGlobal.diceTestEnabled === true) {
            roll = roll + 1;
        }
        else {
            roll = randomInteger(12);
        }

        switch (roll) {
            case 1:
                diceTextLog = diceTextLog + "(Blank)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.BLANK + s2 + "Challenge Blank" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                break;
            case 2:
                diceTextLog = diceTextLog + "(Despair)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.DESPAIR + s2 + "Challenge Despair" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.despair = diceResult.despair + 1;
                break;
            case 3:
                diceTextLog = diceTextLog + "(Failure)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.F + s2 + "Challenge Failure" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.failure = diceResult.failure + 1;
                break;
            case 4:
                diceTextLog = diceTextLog + "(Failure)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.F + s2 + "Challenge Failure" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.failure = diceResult.failure + 1;
                break;
            case 5:
                diceTextLog = diceTextLog + "(Threat)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.T + s2 + "Challenge Threat" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.threat = diceResult.threat + 1;
                break;
            case 6:
                diceTextLog = diceTextLog + "(Threat)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.T + s2 + "Challenge Threat" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.threat = diceResult.threat + 1;
                break;
            case 7:
                diceTextLog = diceTextLog + "(Failure x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.FF + s2 + "Challenge Failure x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.failure = diceResult.failure + 2;
                break;
            case 8:
                diceTextLog = diceTextLog + "(Failure x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.FF + s2 + "Challenge Failure x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.failure = diceResult.failure + 2;
                break;
            case 9:
                diceTextLog = diceTextLog + "(Threat x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.TT + s2 + "Challenge Threat x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.threat = diceResult.threat + 2;
                break;
            case 10:
                diceTextLog = diceTextLog + "(Threat x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.TT + s2 + "Challenge Threat x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.threat = diceResult.threat + 2;
                break;
            case 11:
                diceTextLog = diceTextLog + "(Failure + Threat)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.FT + s2 + "Challenge Failure + Threat" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.failure = diceResult.failure + 1;
                diceResult.threat = diceResult.threat + 1;
                break;
            case 12:
                diceTextLog = diceTextLog + "(Failure + Threat)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.CHALLENGE.FT + s2 + "Challenge Failure + Threat" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.failure = diceResult.failure + 1;
                diceResult.threat = diceResult.threat + 1;
                break;
        }
    }

    if (eedGlobal.diceLogChat === true && eedGlobal.diceLogOnOneLine === false) {
        if (eedGlobal.diceGraphicsChat === true && eedGlobal.diceLogChatWhisper === false) {
            sendChat("", "/direct " + diceGraphicsLog);
        }
        else {
            if (eedGlobal.diceLogChatWhisper === true) {
                sendChat("Challenge", "/w gm " + diceTextLog);
                sendChat("Challenge", "/w " + who + " " + diceTextLog);
            }
            else {
                sendChat("Challenge", diceTextLog);
            }
        }
    }
    return [diceResult, diceTextLog, diceGraphicsLog];
}

function rollForce(diceQty, who) {
    //White "Force" die (d12)
    //1 Light
    //2 Light
    //3 Light + Light
    //4 Light + Light
    //5 Light + Light
    //6 Dark
    //7 Dark
    //8 Dark
    //9 Dark
    //10 Dark
    //11 Dark
    //12 Dark + Dark
    var roll = 0;
    var diceTextLog = "";
    var diceGraphicsLog = "";
    var diceResult = {
        success: 0,
        failure: 0,
        advantage: 0,
        threat: 0,
        triumph: 0,
        despair: 0,
        light: 0,
        dark: 0
    };
    var i = 0;
    var s1 = '<img src="';
    var s2 = '" title="';
    var s3 = '" height="';
    var s4 = '" width="';
    var s5 = '"/>';

    if (eedGlobal.diceTestEnabled === true) {
        diceQty = 12;
    }

    for (i = 1; i <= diceQty; i++) {
        if (eedGlobal.diceTestEnabled === true) {
            roll = roll + 1;
        }
        else {
            roll = randomInteger(12);
        }

        switch (roll) {
            case 1:
                diceTextLog = diceTextLog + "(Light)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.L + s2 + "Force Light" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.light = diceResult.light + 1;
                break;
            case 2:
                diceTextLog = diceTextLog + "(Light)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.L + s2 + "Force Light" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.light = diceResult.light + 1;
                break;
            case 3:
                diceTextLog = diceTextLog + "(Light x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.LL + s2 + "Force Light x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.light = diceResult.light + 2;
                break;
            case 4:
                diceTextLog = diceTextLog + "(Light x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.LL + s2 + "Force Light x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.light = diceResult.light + 2;
                break;
            case 5:
                diceTextLog = diceTextLog + "(Light x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.LL + s2 + "Force Light x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.light = diceResult.light + 2;
                break;
            case 6:
                diceTextLog = diceTextLog + "(Dark)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.D + s2 + "Force Dark" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.dark = diceResult.dark + 1;
                break;
            case 7:
                diceTextLog = diceTextLog + "(Dark)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.D + s2 + "Force Dark" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.dark = diceResult.dark + 1;
                break;
            case 8:
                diceTextLog = diceTextLog + "(Dark)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.D + s2 + "Force Dark" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.dark = diceResult.dark + 1;
                break;
            case 9:
                diceTextLog = diceTextLog + "(Dark)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.D + s2 + "Force Dark" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.dark = diceResult.dark + 1;
                break;
            case 10:
                diceTextLog = diceTextLog + "(Dark)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.D + s2 + "Force Dark" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.dark = diceResult.dark + 1;
                break;
            case 11:
                diceTextLog = diceTextLog + "(Dark)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.D + s2 + "Force Dark" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.dark = diceResult.dark + 1;
                break;
            case 12:
                diceTextLog = diceTextLog + "(Dark x2)";
                diceGraphicsLog = diceGraphicsLog + s1 + eedCONSTANTS.FORCE.DD + s2 + "Force Dark x2" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
                diceResult.dark = diceResult.dark + 2;
                break;
        }
    }

    if (eedGlobal.diceLogChat === true && eedGlobal.diceLogOnOneLine === false) {
        if (eedGlobal.diceGraphicsChat === true && eedGlobal.diceLogChatWhisper === false) {
            sendChat("", "/direct " + diceGraphicsLog);
        }
        else {
            if (eedGlobal.diceLogChatWhisper === true) {
                sendChat("Force", "/w gm " + diceTextLog);
                sendChat("Force", "/w " + who + " " + diceTextLog);
            }
            else {
                sendChat("Force", diceTextLog);
            }
        }
    }
    return [diceResult, diceTextLog, diceGraphicsLog];
}


function diceAddition(diceTotals, diceResult) {
    diceTotals.success = diceTotals.success + diceResult.success;
    diceTotals.failure = diceTotals.failure + diceResult.failure;
    diceTotals.advantage = diceTotals.advantage + diceResult.advantage;
    diceTotals.threat = diceTotals.threat + diceResult.threat;
    diceTotals.triumph = diceTotals.triumph + diceResult.triumph;
    diceTotals.despair = diceTotals.despair + diceResult.despair;
    diceTotals.light = diceTotals.light + diceResult.light;
    diceTotals.dark = diceTotals.dark + diceResult.dark;
    return diceTotals;
}

function diceTotalsSummed(diceTotals) {
    var diceTS = {
        success: 0,
        failure: 0,
        advantage: 0,
        threat: 0,
        triumph: 0,
        despair: 0,
        light: 0,
        dark: 0
    };
    var i = 0;

    i = diceTotals.success - diceTotals.failure;
    if (i >= 0) {
        diceTS.success = i;
    }
    else {
        diceTS.failure = Math.abs(i);
    }

    i = diceTotals.advantage - diceTotals.threat;
    if (i >= 0) {
        diceTS.advantage = i;
    }
    else {
        diceTS.threat = Math.abs(i);
    }
    diceTS.triumph = diceTotals.triumph;
    diceTS.despair = diceTotals.despair;
    diceTS.light = diceTotals.light;
    diceTS.dark = diceTotals.dark;
    return diceTS;
}

function processEdgeEmpireDiceScript(diceToRoll, who) {
    var diceQty = "";
    var diceColor = "";
    var diceTotals = {
        success: 0,
        failure: 0,
        advantage: 0,
        threat: 0,
        triumph: 0,
        despair: 0,
        light: 0,
        dark: 0
    };
    var i = 0;
    var j = diceToRoll.length;
    var diceTextResults = "";
    var diceTextTotals = "";
    var diceGraphicsResults = "";
    var s1 = '<img src="';
    var s2 = '" title="';
    var s3 = '" height="';
    var s4 = '" width="';
    var s5 = '"/>';
    var diceGraphicsTotals = "";

    if (eedGlobal.diceTestEnabled === true) {
        sendChat("", "/desc " + who + ": 6b 8g 12y 6blk 8p 12r 12w");
    }
    else {
        if (eedGlobal.diceLogChatWhisper === true) {
            sendChat(who, "/w gm " + diceToRoll);
            sendChat(who, "/w " + who + " " + diceToRoll);
        }
        else {
            sendChat(who, "/em " + diceToRoll);
        }
    }

    // won't work with >9 dice of one colour yet!
    for (i = 0, j; i < j; i++) {
        diceQty = diceToRoll[i].substring(0, 1);
        diceColor = diceToRoll[i].substring(1);

        switch (diceColor) {
            //Blue "Boost" die (d6)
            case 'b':
                myresults = rollBoost(diceQty, who);
                diceTotals = diceAddition(diceTotals, myresults[0]);
                diceTextTotals = myresults[1];
                diceGraphicsTotals = diceGraphicsTotals + myresults[2];
                break;
            //Green "Ability" die (d8)
            case 'g':
                myresults = rollAbility(diceQty, who);
                diceTotals = diceAddition(diceTotals, myresults[0]);
                diceTextTotals = diceTextTotals + myresults[1];
                diceGraphicsTotals = diceGraphicsTotals + myresults[2];
                break;
            //Yellow "Proficiency" die (d12)
            case 'y':
                myresults = rollProficiency(diceQty, who);
                diceTotals = diceAddition(diceTotals, myresults[0]);
                diceTextTotals = diceTextTotals + myresults[1];
                diceGraphicsTotals = diceGraphicsTotals + myresults[2];
                break;
            //Black "Setback" die (d6)
            case 'blk':
                myresults = rollSetBack(diceQty, who);
                diceTotals = diceAddition(diceTotals, myresults[0]);
                diceTextTotals = diceTextTotals + myresults[1];
                diceGraphicsTotals = diceGraphicsTotals + myresults[2];
                break;
            //Purple "Difficulty" die (d8)
            case 'p':
                myresults = rollDifficulty(diceQty, who);
                diceTotals = diceAddition(diceTotals, myresults[0]);
                diceTextTotals = diceTextTotals + myresults[1];
                diceGraphicsTotals = diceGraphicsTotals + myresults[2];
                break;
            //Red "Challenge" die (d12)
            case 'r':
                myresults = rollChallenge(diceQty, who);
                diceTotals = diceAddition(diceTotals, myresults[0]);
                diceTextTotals = diceTextTotals + myresults[1];
                diceGraphicsTotals = diceGraphicsTotals + myresults[2];
                break;
            //White "Force" die (d12)
            case 'w':
                myresults = rollForce(diceQty, who);
                diceTotals = diceAddition(diceTotals, myresults[0]);
                diceTextTotals = diceTextTotals + myresults[1];
                diceGraphicsTotals = diceGraphicsTotals + myresults[2];
                break;
        }
    }

    diceTotals = diceTotalsSummed(diceTotals);

    diceTextResults = diceTextResults + "[";
    if (diceTotals.success > 0) {
        diceTextResults = diceTextResults + " Success:" + diceTotals.success;
        for (i = 1; i <= diceTotals.success; i++) {
            diceGraphicsResults = diceGraphicsResults + s1 + eedCONSTANTS.SYMBOLS.S + s2 + "Success" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
        }
    }
    if (diceTotals.failure > 0) {
        diceTextResults = diceTextResults + " Fail:" + diceTotals.failure;
        for (i = 1; i <= diceTotals.failure; i++) {
            diceGraphicsResults = diceGraphicsResults + s1 + eedCONSTANTS.SYMBOLS.F + s2 + "Failure" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
        }
    }
    if (diceTotals.advantage > 0) {
        diceTextResults = diceTextResults + " Advant:" + diceTotals.advantage;
        for (i = 1; i <= diceTotals.advantage; i++) {
            diceGraphicsResults = diceGraphicsResults + s1 + eedCONSTANTS.SYMBOLS.A + s2 + "Advantage" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
        }
    }
    if (diceTotals.threat > 0) {
        diceTextResults = diceTextResults + " Threat:" + diceTotals.threat;
        for (i = 1; i <= diceTotals.threat; i++) {
            diceGraphicsResults = diceGraphicsResults + s1 + eedCONSTANTS.SYMBOLS.T + s2 + "Threat" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
        }
    }
    if (diceTotals.triumph > 0) {
        diceTextResults = diceTextResults + " Triumph:" + diceTotals.triumph;
        for (i = 1; i <= diceTotals.triumph; i++) {
            diceGraphicsResults = diceGraphicsResults + s1 + eedCONSTANTS.SYMBOLS.TRIUMPH + s2 + "Triumph" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
        }
    }
    if (diceTotals.despair > 0) {
        diceTextResults = diceTextResults + " Despair:" + diceTotals.despair;
        for (i = 1; i <= diceTotals.despair; i++) {
            diceGraphicsResults = diceGraphicsResults + s1 + eedCONSTANTS.SYMBOLS.DESPAIR + s2 + "Despair" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
        }
    }
    if (diceTotals.light > 0) {
        diceTextResults = diceTextResults + " Light:" + diceTotals.light;
        for (i = 1; i <= diceTotals.light; i++) {
            diceGraphicsResults = diceGraphicsResults + s1 + eedCONSTANTS.SYMBOLS.L + s2 + "Light" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
        }
    }
    if (diceTotals.dark > 0) {
        diceTextResults = diceTextResults + " Dark:" + diceTotals.dark;
        for (i = 1; i <= diceTotals.dark; i++) {
            diceGraphicsResults = diceGraphicsResults + s1 + eedCONSTANTS.SYMBOLS.D + s2 + "Dark" + s3 + eedGlobal.diceGraphicsChatSize + s4 + eedGlobal.diceGraphicsChatSize + s5;
        }
    }

    diceTextResults = diceTextResults + "]";

    if (eedGlobal.diceLogChat === true && eedGlobal.diceLogOnOneLine === true) {
        if (eedGlobal.diceGraphicsChat === true && eedGlobal.diceLogChatWhisper === false) {
            sendChat("", "/direct " + diceGraphicsTotals);
        }
        else {
            if (eedGlobal.diceLogChatWhisper === true) {
                sendChat("Force", "/w gm " + diceTextTotals);
                sendChat("Force", "/w " + who + " " + diceTextTotals);
            }
            else {
                sendChat("Force", diceTextTotals);
            }
        }
    }

    if (eedGlobal.diceGraphicsChat === true && eedGlobal.diceLogChatWhisper === false) {
        sendChat("", "/direct Roll:" + diceGraphicsResults);
    }
    else {
        if (eedGlobal.diceLogChatWhisper === true) {
            sendChat("Roll:", "/w gm " + diceTextResults);
            sendChat("Roll:", "/w " + who + " " + diceTextResults);
        }
        else {
            sendChat("Roll:", "/em " + diceTextResults);
        }
    }
}

var processScriptTabs = function (argv, who) {
    // this will run the various other scripts depending upon the chat
    // window command.  Just add another Case statement to add a new command.
    var tmpLogChat = false;
    var tmpGraphicsChat = false;

    var script = argv.shift();

    switch (script) {
        case eedCONSTANTS.EEDCOMMAND:
            switch (argv[0]) {
                case "log":
                    switch (argv[1]) {
                        case "on":
                            eedGlobal.diceLogChat = true;
                            break;
                        case "off":
                            eedGlobal.diceLogChat = false;
                            break;
                    }
                    break;
                case "w":
                    eedGlobal.diceLogChatWhisper = true;
                    argv.shift();
                    processEdgeEmpireDiceScript(argv, who);
                    eedGlobal.diceLogChatWhisper = false;
                    break;
                case "graphics":
                    switch (argv[1]) {
                        case "on":
                            eedGlobal.diceGraphicsChat = true;
                            break;
                        case "off":
                            eedGlobal.diceGraphicsChat = false;
                            break;
                        case "s":
                            eedGlobal.diceGraphicsChatSize = eedCONSTANTS.GRAPHICSIZE.SMALL;
                            break;
                        case "m":
                            eedGlobal.diceGraphicsChatSize = eedCONSTANTS.GRAPHICSIZE.MEDIUM;
                            break;
                        case "l":
                            eedGlobal.diceGraphicsChatSize = eedCONSTANTS.GRAPHICSIZE.LARGE;
                            break;
                    }
                    break;
                case "test":
                    eedGlobal.diceTestEnabled = true;
                    tmpLogChat = eedGlobal.diceLogChat;
                    tmpGraphicsChat = eedGlobal.diceGraphicsChat;
                    eedGlobal.diceLogChat = true;
                    eedGlobal.diceGraphicsChat = true;
                    processEdgeEmpireDiceScript(["1b", "1g", "1y", "1blk", "1p", "1r", "1w"], who);
                    eedGlobal.diceTestEnabled = false;
                    eedGlobal.diceLogChat = tmpLogChat;
                    eedGlobal.diceGraphicsChat = tmpGraphicsChat;
                    break;
                default:
                    processEdgeEmpireDiceScript(argv, who);
                    eedGlobal.diceLogChatWhisper = false;
            }
            break;
    }
};

on("chat:message", function (msg) {
    // returns the chat window command entered, all in lowercase.

    var chatCommand = msg.content;
    chatCommand = chatCommand.toLowerCase(); //make all characters lowercase

    var argv = chatCommand.split(' ');
    if (msg.type != 'api') {
        return;
    }
    return processScriptTabs(argv, msg.who);
});