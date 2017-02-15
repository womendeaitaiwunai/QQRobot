package example.lxl.myapplication.util.anima;

import android.content.res.AssetManager;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;

import su.levenetc.android.textsurface.contants.Align;
import su.levenetc.android.textsurface.Text;
import su.levenetc.android.textsurface.TextBuilder;
import su.levenetc.android.textsurface.TextSurface;
import su.levenetc.android.textsurface.animations.Alpha;
import su.levenetc.android.textsurface.animations.ChangeColor;
import su.levenetc.android.textsurface.animations.Circle;
import su.levenetc.android.textsurface.animations.Delay;
import su.levenetc.android.textsurface.animations.Parallel;
import su.levenetc.android.textsurface.animations.Rotate3D;
import su.levenetc.android.textsurface.animations.Sequential;
import su.levenetc.android.textsurface.animations.ShapeReveal;
import su.levenetc.android.textsurface.animations.SideCut;
import su.levenetc.android.textsurface.animations.Slide;
import su.levenetc.android.textsurface.animations.TransSurface;
import su.levenetc.android.textsurface.contants.Direction;
import su.levenetc.android.textsurface.contants.Pivot;
import su.levenetc.android.textsurface.contants.Side;

/**
 * Created by Eugene Levenetc.
 */
public class CookieThumperSample {

	public static void play(TextSurface textSurface, AssetManager assetManager) {

		final Typeface robotoBlack = Typeface.createFromAsset(assetManager, "fonts/Roboto-Black.ttf");
		Paint paint = new Paint();
		paint.setAntiAlias(true);
		paint.setTypeface(robotoBlack);

		Text textDaai = TextBuilder
				.create("作者：龙大大")
				.setPaint(paint)
				.setSize(64)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.SURFACE_CENTER).build();

		Text textBraAnies = TextBuilder
				.create("故乡:江西")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.WHITE)
				.setPosition(Align.BOTTOM_OF, textDaai).build();

		Text textFokkenGamBra = TextBuilder
				.create(" 泰和")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.WHITE)
				.setPosition(Align.RIGHT_OF, textBraAnies).build();

		Text textHaai = TextBuilder
				.create("九江学院")
				.setPaint(paint)
				.setSize(55)
				.setAlpha(0)
				.setColor(Color.WHITE)
				.setPosition(Align.BOTTOM_OF, textFokkenGamBra).build();

		Text textDaaiAnies = TextBuilder
				.create("计算机软件技术")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textHaai).build();

		Text texThyLamInnie = TextBuilder
				.create(" 最想说的话:")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.WHITE)
				.setPosition(Align.RIGHT_OF, textDaaiAnies).build();

		Text textThrowDamn = TextBuilder
				.create("我嫉妒你对他的好")
				.setPaint(paint)
				.setSize(30)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, texThyLamInnie).build();

		Text textDevilishGang = TextBuilder
				.create("甚至甘愿受伤")
				.setPaint(paint)
				.setSize(30)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textThrowDamn).build();

		Text textSignsInTheAir = TextBuilder
				.create("++++++++++")
				.setPaint(paint)
				.setSize(44)
				.setAlpha(0)
				.setColor(Color.RED)
				.setPosition(Align.BOTTOM_OF | Align.CENTER_OF, textDevilishGang).build();

		textSurface.play(
				new Sequential(
						ShapeReveal.create(textDaai, 750, SideCut.show(Side.LEFT), false),
						new Parallel(ShapeReveal.create(textDaai, 600, SideCut.hide(Side.LEFT), false), new Sequential(Delay.duration(300), ShapeReveal.create(textDaai, 600, SideCut.show(Side.LEFT), false))),
						new Parallel(new TransSurface(500, textBraAnies, Pivot.CENTER), ShapeReveal.create(textBraAnies, 1300, SideCut.show(Side.LEFT), false)),
						Delay.duration(500),
						new Parallel(new TransSurface(750, textFokkenGamBra, Pivot.CENTER), Slide.showFrom(Side.LEFT, textFokkenGamBra, 750), ChangeColor.to(textFokkenGamBra, 750, Color.WHITE)),
						Delay.duration(500),
						new Parallel(TransSurface.toCenter(textHaai, 500), Rotate3D.showFromSide(textHaai, 750, Pivot.TOP)),
						new Parallel(TransSurface.toCenter(textDaaiAnies, 500), Slide.showFrom(Side.TOP, textDaaiAnies, 500)),
						new Parallel(TransSurface.toCenter(texThyLamInnie, 750), Slide.showFrom(Side.LEFT, texThyLamInnie, 500)),
						new Parallel(Alpha.hide(textDaai,50),Alpha.hide(textBraAnies,50),Alpha.hide(textFokkenGamBra,50),
								Alpha.hide(textHaai,50),Alpha.hide(textDaaiAnies,50)),
						Delay.duration(500),
						new Parallel(
								new TransSurface(1500, textSignsInTheAir, Pivot.CENTER),
								new Sequential(
										new Sequential(ShapeReveal.create(textThrowDamn, 500, Circle.show(Side.CENTER, Direction.OUT), false)),
										new Sequential(ShapeReveal.create(textDevilishGang, 500, Circle.show(Side.CENTER, Direction.OUT), false)),
										new Sequential(ShapeReveal.create(textSignsInTheAir, 500, Circle.show(Side.CENTER, Direction.OUT), false))
								)
						)
//						Delay.duration(200),
//						new Parallel(
//								ShapeReveal.create(textThrowDamn, 1500, SideCut.hide(Side.LEFT), true),
//								new Sequential(Delay.duration(250), ShapeReveal.create(textDevilishGang, 1500, SideCut.hide(Side.LEFT), true)),
//								new Sequential(Delay.duration(500), ShapeReveal.create(textSignsInTheAir, 1500, SideCut.hide(Side.LEFT), true)),
//								Alpha.hide(texThyLamInnie, 1500)
//						)
				)
		);

	}

}
