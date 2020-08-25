package minimalmenu.mixin;

import minimalmenu.MinimalMenu;
import minimalmenu.config.ConfigHandler;
import net.minecraft.client.gui.CubeMapRenderer;
import net.minecraft.client.gui.RotatingCubeMapRenderer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.TitleScreen;
import net.minecraft.client.gui.widget.AbstractButtonWidget;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    @Shadow public static final CubeMapRenderer PANORAMA_CUBE_MAP = new CubeMapRenderer(new Identifier("textures/gui/title/background/panorama"));
    @Shadow private String splashText;
    @Shadow private int copyrightTextX;
    @Shadow private final RotatingCubeMapRenderer backgroundRenderer;
    protected TitleScreenMixin(Text title) {
        super(title);
        backgroundRenderer = new RotatingCubeMapRenderer(PANORAMA_CUBE_MAP);;
    }

    @Inject(at = @At("TAIL"), method = "init()V")
    protected void init(CallbackInfo info) {
        if (ConfigHandler.REMOVE_SPLASH) {
            splashText = null;
        }

        if (ConfigHandler.REMOVE_COPYRIGHT) {
            copyrightTextX = 1000000000;
        }
        
//        if (MinimalMenu.getConfigHandler().DO_SPLASH_TEXT_REMOVAL) {
//            splashText = "";
//        }
//        if (MinimalMenu.getConfigHandler().DO_COPYRIGHT_TEXT_REMOVAL) {
//            copyrightTextX = 1000000000; //Yeah I know....
//        }
//
//        MinimalMenu.getConfigHandler().read();
//        if (MinimalMenu.allInstalledIDS().contains("modmenu")) { //Do logic for mod menu.
//            for (AbstractButtonWidget button : this.buttons) {
//                if (MinimalMenu.getConfigHandler().DO_REALMS_REMOVAL) { //Realms removal logic.
//                    if (buttons.indexOf(button) == 2) {
//                        button.visible = false;
//                    } else if (buttons.indexOf(button) == 3 ||
//                               buttons.indexOf(button) == 4 ||
//                               buttons.indexOf(button) == 5 ||
//                               buttons.indexOf(button) == 6 ||
//                               buttons.indexOf(button) == 7) {
//                        button.y -= 24; //Move buttons below realms to fill in the space.
//                    }
//                    if (MinimalMenu.getConfigHandler().DO_CENTER_ADJUSTMENT) {
//                        button.y += 24;
//                    }
//                }
//
//                if (MinimalMenu.getConfigHandler().DO_LANGUAGE_BUTTON_REMOVAL && buttons.indexOf(button) == 4) {
//                    button.visible = false;
//                }
//
//                if (MinimalMenu.getConfigHandler().DO_ACCESSIBILITY_BUTTON_REMOVAL && buttons.indexOf(button) == 7) {
//                    button.visible = false;
//                }
//            }
//        } else { //Do logic for no mod menu installation.
//            for (AbstractButtonWidget button : this.buttons) {
//                if (MinimalMenu.getConfigHandler().DO_REALMS_REMOVAL) {
//                    if (buttons.indexOf(button) == 2) {
//                        button.visible = false;
//                    } else if (buttons.indexOf(button) == 3 ||
//                               buttons.indexOf(button) == 4 ||
//                               buttons.indexOf(button) == 5 ||
//                               buttons.indexOf(button) == 6) {
//                        button.y -= 24; //Move buttons below realms to fill in the space.
//                    }
//                    if (MinimalMenu.getConfigHandler().DO_CENTER_ADJUSTMENT) {
//                        button.y += 24;
//                    }
//                }
//
//                if (MinimalMenu.getConfigHandler().DO_LANGUAGE_BUTTON_REMOVAL && buttons.indexOf(button) == 3) {
//                    button.visible = false;
//                }
//
//                if (MinimalMenu.getConfigHandler().DO_ACCESSIBILITY_BUTTON_REMOVAL && buttons.indexOf(button) == 6) {
//                    button.visible = false;
//                }
//            }
//        }
    }
//
//    //Removes realms notifications from the screen.
//    @Inject(at = @At("HEAD"), method = "init()V")
//    protected void setRealmsNotificationsToFalse(CallbackInfo info) {
//        if (MinimalMenu.getConfigHandler().DO_REALMS_REMOVAL) {
//            assert this.client != null;
//            this.client.options.realmsNotifications = false;
//        }
//    }
}
