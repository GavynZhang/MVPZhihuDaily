package com.gavynzhang.mvpzhihudaily.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.gavynzhang.mvpzhihudaily.R;

public class ArticleContentActivity extends AppCompatActivity {

    private WebView mWebView;

    public static void actionStart(Context context, String id){
        Intent intent = new Intent(context, ArticleContentActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_content);
        initViews();
        String data = "<div class=\\\"main-wrap content-wrap\\\">\n" +
                "<div class=\\\"headline\\\">\n" +
                "\n" +
                "<div class=\\\"img-place-holder\\\"></div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "<div class=\\\"content-inner\\\">\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\\\"question\\\">\n" +
                "<h2 class=\\\"question-title\\\"></h2>\n" +
                "\n" +
                "<div class=\\\"answer\\\">\n" +
                "\n" +
                "<div class=\\\"content\\\">\n" +
                "<p style=\\\"text-align: center;\\\">* * *</p>\n" +
                "<p style=\\\"text-align: center;\\\">10 年前是 2006 年，</p>\n" +
                "<p style=\\\"text-align: center;\\\">不是 1996 年</p>\n" +
                "<p style=\\\"text-align: center;\\\">* * *</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "\n" +
                "<div class=\\\"question\\\">\n" +
                "<h2 class=\\\"question-title\\\">在你亲历的短短的时间内，世界有哪些惊人的改变？</h2>\n" +
                "\n" +
                "<div class=\\\"answer\\\">\n" +
                "\n" +
                "<div class=\\\"meta\\\">\n" +
                "<img class=\\\"avatar\\\" src=\\\"http://pic1.zhimg.com/da8e974dc_is.jpg\\\">\n" +
                "<span class=\\\"author\\\">知乎用户，</span><span class=\\\"bio\\\">信息安全</span>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\\\"content\\\">\n" +
                "<p>短短的时间是多久？</p>\n" +
                "<p>我小学的时候，爸妈还在用 BB 机（传呼机），后来手机开始普及，初三时我有第一台手机，是联想的。</p>\n" +
                "<p>这其中有多少年？也没有多少。</p>\n" +
                "<p>刚上高中时流行发短信，每个月订个 1000 条短信，动感地带拇指派，和别人发短信都一条一条地数着，但总会一会儿就用光了。</p>\n" +
                "<p>高二下又开始流行飞信，总在开年级大会的时候，打开飞信疯狂地给基友发短信，刷他的屏，看着他不一会就好几百的未读信息，边偷笑边假装认真听年级大会。</p>\n" +
                "<p>到了大学又开始了微信，逐渐有了 3G 和 4G。你看现在还有谁用短信和飞信。</p>\n" +
                "<p>这其中有多少年？也没有多少年。</p>\n" +
                "<p>小学时候趁爸妈不在家，彻夜地打 CS，练甩狙，练盲狙，练 AK47 压枪，看 SK 的 CS 比赛看的热血沸腾，打雪地刚开始记得对墙来一狙，打开控制台输入 /sv_gravity 50 还能满天飞。</p>\n" +
                "<p>到后来的 who is your daddy，LOL，到现在守望屁股。</p>\n" +
                "<p>我 CS1.5 这么多年都不舍得删，里面有我的热血和无数的网友自制地图。</p>\n" +
                "<p>这其中有多少年？也没有多少年。</p>\n" +
                "<p>小学时从广东去上海要坐老式的动车，况且况且，坐了一天一夜，睡了个卧铺，嗑着瓜子，听着夜里周围的打呼声，看看窗外风景，终于到站了出来伸个懒腰。</p>\n" +
                "<p>到后来飞机的降价和快速列车的出现，到哪里都开始变得很方便。</p>\n" +
                "<p>这其中有多少年？也没有多少年。</p>\n" +
                "<p>对了，还有小学用的第一台电脑是联想的，是 win 几我忘了，我还记得特爱玩那个联想之家里的游戏，还有推箱子。到现在的 Win10 和 Mac。</p>\n" +
                "<p>高二时买的第二台手机是 N78，高兴地到处显摆。选手机时还在考虑要翻盖呢，还是平板。到了高三大家用上了爱疯和爱派德，玩上了切水果，植物大战僵尸和愤怒的小鸟。</p>\n" +
                "<p>到现在诺基亚早已分不了天下一瓢，爱疯也已经要出 7 了。</p>\n" +
                "<p>小学时的数码宝贝，四驱兄弟，神奇宝贝，阿拉蕾，圣斗士星矢，幽游白书，龙珠，初中时的游戏王，神龙斗士，百变小樱，高中时的钢炼，海贼王，火影和死神，大学时的妖尾，寄生兽和东京食尸鬼……（不按严格时间排）</p>\n" +
                "<p>谁还记得以前玩过的 flash 小游戏，谁还记得 Windows 的蓝屏，谁还记得当年冥王星还是 9 大行星之一，谁还记得当年的杨利伟，谁还记得北京奥运会放飞的脚步烟火，谁还记得上海世博会的人山人海……</p>\n" +
                "<p>这其中有多少年？也没多少年。</p>\n" +
                "<p>我们都记得。</p>\n" +
                "<p>中国变了多少。这个世界又变了多少。</p>\n" +
                "<p>一生也没多少年。</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\\\"answer\\\">\n" +
                "\n" +
                "<div class=\\\"meta\\\">\n" +
                "<img class=\\\"avatar\\\" src=\\\"http://pic4.zhimg.com/6ec691527_is.jpg\\\">\n" +
                "<span class=\\\"author\\\">fishmoon，</span><span class=\\\"bio\\\">只与同好争高下，不共傻逼论短长。</span>\n" +
                "</div>\n" +
                "\n" +
                "<div class=\\\"content\\\">\n" +
                "<p>最惊人的改变，莫过于常识被颠覆吧。</p>\n" +
                "<p>前几天翻女儿的科普读物，发现上面赫然写着“太阳系八大行星”。</p>\n" +
                "<p>我去，太阳系有九大行星，在我小时候是最基本的常识啊，那时谁要是说太阳系有八大行星，肯定被笑话死了，结果现在，真的变成八大行星了，那颗行星哪去了？自爆了吗？我怎么不知道？</p>\n" +
                "<p>再往下翻，介绍世界最高峰珠穆朗玛峰，海拔 8844 米。</p>\n" +
                "<p>我去，珠穆朗玛峰海拔 8848 米，这是我张口就来的数字啊，当年还有个著名的网站就叫 8848，怎么变 8844 米了，珠峰什么时候矮了 4 米？什么时候？</p>\n" +
                "<p>忽然，我意识到，我可能买到误人子弟的坑爹读物了，于是我开始上网搜索。</p>\n" +
                "<p>我去，搜索的结果是，书上写的是对的。冥王星不再被认为是行星，珠峰高度重新测量了，而且这两件事都过去十年了。</p>\n" +
                "<p>这时的我，真的不淡定了。</p>\n" +
                "<p>我想起前几天的一件事，女儿问我法国用什么钱，我脱口而出:法郎。可是过了一会儿，我忽然意识到，不对，法国使用的货币应该是欧元。</p>\n" +
                "<p>我终于明白为什么会有代沟存在。</p>\n" +
                "<p>我们在成长过程中学到了很多叫常识的东西，我们认为他们天经地义，不言自明，而我们的知识结构，思想三观和行为方式，都建立在那些常识的基础上。可我们生活的世界以及我们对世界的认识，是那么飞快的变化着，很多我们认为最天经地义的常识都随时会被颠覆。新一代的人们，他们有着全新的常识，自然也有着新的知识结构，思想三观和行为方式。</p>\n" +
                "<p>女儿很小的时候，我抱着她坐电梯，我们的面前有一块播放广告的电子屏，我只是去看它，而女儿很自然的伸出手指想去滑动它。</p>\n" +
                "<p>我是看电视长大的，屏幕是用来看的，这是常识。而女儿是玩手机和 iPad 长大的，屏幕是用来看的，也是用来摸的，这也是常识。</p>\n" +
                "<p>还有一次，和女儿一起去看电影，进了影院她忽然说，怎么不发眼镜啊？我忽然意识到，她从第一次看电影开始，看的都是 3D 电影，这是她第一次看 2D 电影。在她的世界里，看电影需要戴眼镜，这是常识，而我并没有这样的常识。</p>\n" +
                "<p>经历过很多类似的事情，我越来越能够理解，不同代际之间的人，为什么总会觉得对方是那么的不可理喻。</p>\n" +
                "<p>还有一次，我问女儿天空是什么颜色的？女儿脱口而出：白色的。我先是很惊讶，难道不应该是蓝天白云吗？可当我看到窗外的雾霾天，才明白了那的确是她眼中的真相。</p>\n" +
                "<p>正当我心里五味杂陈的时候，女儿又说:“有时也是蓝色的。应该是白色和蓝色。”</p>\n" +
                "<p>哦，好吧。</p>\n" +
                "</div>\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "<div class=\\\"view-more\\\"><a href=\\\"http://www.zhihu.com/question/52231322\\\">查看知乎讨论<span class=\\\"js-question-holder\\\"></span></a></div>\n" +
                "\n" +
                "</div>\n" +
                "\n" +
                "\n" +
                "</div>\n" +
                "</div>";
        mWebView.loadData(data,"text/html","UTF-8");
    }

    private void initViews(){
        mWebView = (WebView)findViewById(R.id.article_content);
    }
}
