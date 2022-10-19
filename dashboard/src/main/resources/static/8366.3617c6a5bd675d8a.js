"use strict";var G=Object.defineProperty,z=Object.defineProperties,$=Object.getOwnPropertyDescriptors,H=Object.getOwnPropertySymbols,J=Object.prototype.hasOwnProperty,Q=Object.prototype.propertyIsEnumerable,Z=(u,o,e)=>o in u?G(u,o,{enumerable:!0,configurable:!0,writable:!0,value:e}):u[o]=e,K=(u,o)=>{for(var e in o||(o={}))J.call(o,e)&&Z(u,e,o[e]);if(H)for(var e of H(o))Q.call(o,e)&&Z(u,e,o[e]);return u},N=(u,o)=>z(u,$(o));(self.webpackChunkdashboard=self.webpackChunkdashboard||[]).push([[8366],{88366:(u,o,e)=>{e.r(o),e.d(o,{default:()=>w});var s=e(60046),C=e(9077),E=(e(67474),e(57025),e(33870),e(42442)),D=(e(26436),e(27001)),r=(e(36320),e(40150),e(94345),e(82705),e(13006),e(48082),e(91099));class b extends r.Z{constructor(){super(...arguments),this._lastWidth=0,this._lastHeight=0,this.requiresDedicatedFBO=!1}dispose(){this._renderTarget&&(this._renderTarget.dispose(),this._renderTarget=null)}doRender(i){const h=this.createRenderParams(i),{context:a,painter:v,profiler:g}=h;this._prevFBO=a.getBoundFramebufferObject(),g.recordContainerStart(this.name);const p=this._getFbo(h),c=v.getRenderTarget();a.bindFramebuffer(p),v.setRenderTarget(p),a.setDepthWriteEnabled(!0),a.setColorMask(!0,!0,!0,!0),a.setClearColor(0,0,0,0),a.setClearDepth(1),a.clear(a.gl.COLOR_BUFFER_BIT|a.gl.DEPTH_BUFFER_BIT),a.setDepthWriteEnabled(!1);for(const n of this.children)n.beforeRender(i);for(const n of this.children)n.processRender(h);for(const n of this.children)n.afterRender(i);v.setRenderTarget(c),a.bindFramebuffer(this._prevFBO),v.beforeRenderLayer(h,this._clippingInfos?255:0,this.computedOpacity),a.setStencilTestEnabled(!1),a.setStencilWriteMask(0),v.blitTexture(a,p.colorTexture,9728),v.compositeLayer(h,this.computedOpacity),g.recordContainerEnd()}createRenderParams(i){return N(K({},super.createRenderParams(i)),{blendMode:this.blendMode,effects:this.computedEffects,globalOpacity:1})}_getFbo(i){const{context:h,painter:a}=i,{width:v,height:g}=h.getViewport();return v===this._lastWidth&&g===this._lastHeight||(this._lastWidth=v,this._lastHeight=g,this._renderTarget?this._renderTarget.resize(v,g):this._renderTarget=new D.Z(h,{colorTarget:0,depthStencilTarget:3},{target:3553,pixelFormat:6408,dataType:5121,samplingMode:9728,wrapMode:33071,width:v,height:g},a.getSharedStencilBuffer())),this._renderTarget}}var U=e(70297),I=e(76011),j=e(55208),x=e(59989);let f=class extends x.Z{constructor(t){super(t),this.type="group",this.layerViews=new I.Z}initialize(){this.handles.add([this.layerViews.on("change",t=>this._layerViewsChangeHandler(t)),this.layerViews.on("after-changes",()=>this._layerViewsAfterChangesHandler()),this.layer.watch("visibilityMode",()=>this._visibilityModeHandler(),!0),this.watch("visible",()=>this._visibleHandler(),!0)],"grouplayerview"),this._layerViewsChangeHandler({target:null,added:this.layerViews.toArray(),removed:[],moved:[]}),this._layerViewsAfterChangesHandler()}set layerViews(t){this._set("layerViews",(0,j.Z)(t,this._get("layerViews")))}isUpdating(){return this.layerViews.some(t=>t.updating)}get updatingProgress(){return 0===this.layerViews.length?1:this.layerViews.reduce((t,i)=>t+i.updatingProgress,0)/this.layerViews.length}_hasLayerViewVisibleOverrides(){return this.layerViews.some(t=>t._isOverridden("visible"))}_findLayerViewForLayer(t){return t&&this.layerViews.find(i=>i.layer===t)}_firstVisibleOnLayerOrder(){const t=this.layer.layers.find(i=>{const h=this._findLayerViewForLayer(i);return h&&h.visible});return t&&this._findLayerViewForLayer(t)}_enforceExclusiveVisibility(t){this._hasLayerViewVisibleOverrides()&&(t||!(t=this._firstVisibleOnLayerOrder())&&this.layerViews.length>0&&(t=this._findLayerViewForLayer(this.layer.layers.getItemAt(0))),this.layerViews.forEach(i=>{i.visible=i===t}))}_layerViewsChangeHandler(t){this.handles.remove("grouplayerview:visible"),this.handles.add(this.layerViews.map(a=>a.watch("visible",v=>this._layerViewVisibleHandler(v,a),!0)).toArray(),"grouplayerview:visible");const i=t.added[t.added.length-1];let h=null;i&&i.visible&&(h=i),this._enforceVisibility(h)}_layerViewsAfterChangesHandler(){this.handles.remove("grouplayerview:updating"),this.handles.add(this.layerViews.map(t=>t.watch("updating",()=>this._updateUpdating(),!0)).toArray(),"grouplayerview:updating"),this._updateUpdating()}_enforceVisibility(t){if(this._hasLayerViewVisibleOverrides())switch(this.layer.visibilityMode){case"inherited":{const i=this.visible;this.layerViews.forEach(h=>{h.visible=i});break}case"exclusive":this._enforceExclusiveVisibility(t)}}_visibilityModeHandler(){this._enforceVisibility()}_layerViewVisibleHandler(t,i){if(this._hasLayerViewVisibleOverrides())switch(this.layer.visibilityMode){case"inherited":t!==this.visible&&(i.visible=this.visible);break;case"exclusive":this._enforceExclusiveVisibility(t&&i)}}_visibleHandler(){var t;this._hasLayerViewVisibleOverrides()&&"inherited"===(null==(t=this.layer)?void 0:t.visibilityMode)&&this._enforceVisibility()}_updateUpdating(){this.notifyChange("updating")}};(0,s._)([(0,C.Cb)({cast:j.R})],f.prototype,"layerViews",null),(0,s._)([(0,C.Cb)()],f.prototype,"view",void 0),(0,s._)([(0,C.Cb)({readOnly:!0})],f.prototype,"updatingProgress",null),f=(0,s._)([(0,E.j)("esri.views.layers.GroupLayerView")],f);var L=f;let R=class extends((0,U.y)(L)){constructor(){super(...arguments),this.container=new b}attach(){this._updateStageChildren(),this.handles.add(this.layerViews.on("after-changes",()=>this._updateStageChildren()),"grouplayerview2d")}detach(){this.handles.remove("grouplayerview2d"),this.container.removeAllChildren()}hitTest(t,i){return null}update(t){}moveStart(){}viewChange(){}moveEnd(){}_updateStageChildren(){this.container.removeAllChildren(),this.layerViews.forEach((t,i)=>this.container.addChildAt(t.container,i))}};R=(0,s._)([(0,E.j)("esri.views.2d.layers.GroupLayerView2D")],R);var w=R},70297:(u,o,e)=>{e.d(o,{y:()=>v});var s=e(60046),C=e(76011),P=e(55208),m=e(97467),l=e(9077),y=(e(67474),e(57025),e(33870),e(42442)),S=e(29729),A=e(54792);let V=class extends A.wq{};V=(0,s._)([(0,y.j)("esri.views.layers.support.ClipArea")],V);var O,d=V;let r=O=class extends d{constructor(){super(...arguments),this.type="rect",this.left=null,this.right=null,this.top=null,this.bottom=null}clone(){return new O({left:this.left,right:this.right,top:this.top,bottom:this.bottom})}get version(){return(this._get("version")||0)+1}};(0,s._)([(0,l.Cb)({type:[Number,String],json:{write:!0}})],r.prototype,"left",void 0),(0,s._)([(0,l.Cb)({type:[Number,String],json:{write:!0}})],r.prototype,"right",void 0),(0,s._)([(0,l.Cb)({type:[Number,String],json:{write:!0}})],r.prototype,"top",void 0),(0,s._)([(0,l.Cb)({type:[Number,String],json:{write:!0}})],r.prototype,"bottom",void 0),(0,s._)([(0,l.Cb)({readOnly:!0})],r.prototype,"version",null),r=O=(0,s._)([(0,y.j)("esri.views.layers.support.ClipRect")],r);var L,b=r,I=(e(73513),e(40485)),j=e(52917),x=e(82059),f=e(70393);const R={base:I.Z,key:"type",typeMap:{extent:x.Z,polygon:f.Z}};let w=L=class extends d{constructor(){super(...arguments),this.type="geometry",this.geometry=null}get version(){return(this._get("version")||0)+1}clone(){return new L({geometry:this.geometry.clone()})}};(0,s._)([(0,l.Cb)({types:R,json:{read:j.im,write:!0}})],w.prototype,"geometry",void 0),(0,s._)([(0,l.Cb)({readOnly:!0})],w.prototype,"version",null),w=L=(0,s._)([(0,y.j)("esri.views.layers.support.Geometry")],w);var t=w;let i=class extends d{constructor(){super(...arguments),this.type="path",this.path=[]}get version(){return(this._get("version")||0)+1}};(0,s._)([(0,l.Cb)({type:[[[Number]]],json:{write:!0}})],i.prototype,"path",void 0),(0,s._)([(0,l.Cb)({readOnly:!0})],i.prototype,"version",null),i=(0,s._)([(0,y.j)("esri.views.layers.support.Path")],i);const a=C.Z.ofType({key:"type",base:d,typeMap:{rect:b,path:i,geometry:t}}),v=g=>{let p=class extends g{constructor(){super(...arguments),this.clips=new a,this.moving=!1,this.attached=!1,this.lastUpdateId=-1,this.updateRequested=!1}initialize(){var c;this.container||(this.container=new S.W),this.container.fadeTransitionEnabled=!0,this.container.opacity=0,this.container.clips=this.clips,this.handles.add([(0,m.S1)(this,"suspended",n=>{this.container&&(this.container.visible=!n),this.view&&!n&&this.updateRequested&&this.view.requestUpdate()},!0),(0,m.S1)(this,["layer.opacity","container"],()=>{var n,M;this.container&&(this.container.opacity=null!=(n=null==(M=this.layer)?void 0:M.opacity)?n:1)},!0),(0,m.S1)(this,["layer.blendMode"],n=>{this.container&&(this.container.blendMode=n)},!0),(0,m.S1)(this,["layer.effect"],n=>{this.container&&(this.container.effect=n)},!0),this.clips.on("change",()=>{this.container.clips=this.clips,this.notifyChange("clips")})]),null!=(c=this.view)&&c.whenLayerView?this.view.whenLayerView(this.layer).then(n=>{n!==this||this.attached||this.destroyed||(this.attach(),this.requestUpdate(),this.attached=!0)},()=>{}):this.when().then(()=>{this.attached||this.destroyed||(this.attach(),this.requestUpdate(),this.attached=!0)},()=>{})}destroy(){this.attached&&(this.detach(),this.attached=!1),this.handles.remove("initialize"),this.updateRequested=!1}get updating(){return!this.attached||!this.suspended&&(this.updateRequested||this.isUpdating())}isVisibleAtScale(c){let n=!0;const M=this.layer,B=M.minScale,W=M.maxScale;if(null!=B&&null!=W){let F=!B,_=!W;!F&&c<=B&&(F=!0),!_&&c>=W&&(_=!0),n=F&&_}return n}requestUpdate(){this.destroyed||this.updateRequested||(this.updateRequested=!0,this.suspended||this.view.requestUpdate())}processUpdate(c){!this.isFulfilled()||this.isResolved()?(this._set("updateParameters",c),this.updateRequested&&!this.suspended&&(this.updateRequested=!1,this.update(c))):this.updateRequested=!1}isUpdating(){return!1}isRendering(){return!1}canResume(){return!!super.canResume()&&this.isVisibleAtScale(this.view.scale)}};return(0,s._)([(0,l.Cb)({type:a,set(c){const n=(0,P.Z)(c,this._get("clips"),a);this._set("clips",n)}})],p.prototype,"clips",void 0),(0,s._)([(0,l.Cb)()],p.prototype,"moving",void 0),(0,s._)([(0,l.Cb)()],p.prototype,"attached",void 0),(0,s._)([(0,l.Cb)()],p.prototype,"container",void 0),(0,s._)([(0,l.Cb)()],p.prototype,"suspended",void 0),(0,s._)([(0,l.Cb)({readOnly:!0})],p.prototype,"updateParameters",void 0),(0,s._)([(0,l.Cb)()],p.prototype,"updateRequested",void 0),(0,s._)([(0,l.Cb)()],p.prototype,"updating",null),(0,s._)([(0,l.Cb)()],p.prototype,"view",void 0),p=(0,s._)([(0,y.j)("esri.views.2d.layers.LayerView2D")],p),p}},59989:(u,o,e)=>{e.d(o,{Z:()=>O});var s=e(60046),C=e(64859),P=e(77624),m=e(10882),l=e(21511),E=e(33870),T=e(60305),D=e(73763),y=e(9077),V=(e(67474),e(57025),e(42442));let d=class extends((0,m.p)((0,l.I)((0,D.v)(P.Z.EventedMixin(C.Z))))){constructor(r){super(r),this.layer=null,this.parent=null}initialize(){this.when().catch(r=>{if("layerview:create-error"!==r.name){const b=this.layer&&this.layer.id||"no id",U=this.layer&&this.layer.title||"no title";throw E.Z.getLogger(this.declaredClass).error("#resolve()",`Failed to resolve layer view (layer title: '${U}', id: '${b}')`,r),r}})}get fullOpacity(){return(0,T.Pt)(this.get("layer.opacity"),1)*(0,T.Pt)(this.get("parent.fullOpacity"),1)}get suspended(){return!this.canResume()}get suspendInfo(){return this.getSuspendInfo()}get legendEnabled(){return!this.suspended&&!0===this.layer.legendEnabled}get updating(){return!!(this.updatingHandles&&this.updatingHandles.updating||this.isUpdating())}get updatingProgress(){return this.updating?0:1}get visible(){return!0===this.get("layer.visible")}set visible(r){void 0!==r?this._override("visible",r):this._clearOverride("visible")}canResume(){return!this.get("parent.suspended")&&this.get("view.ready")&&this.get("layer.loaded")&&this.visible||!1}getSuspendInfo(){const r=this.parent&&this.parent.suspended?this.parent.suspendInfo:{};return this.view&&this.view.ready||(r.viewNotReady=!0),this.layer&&this.layer.loaded||(r.layerNotLoaded=!0),this.visible||(r.layerInvisible=!0),r}isUpdating(){return!1}};(0,s._)([(0,y.Cb)()],d.prototype,"fullOpacity",null),(0,s._)([(0,y.Cb)()],d.prototype,"layer",void 0),(0,s._)([(0,y.Cb)()],d.prototype,"parent",void 0),(0,s._)([(0,y.Cb)({readOnly:!0})],d.prototype,"suspended",null),(0,s._)([(0,y.Cb)({readOnly:!0})],d.prototype,"suspendInfo",null),(0,s._)([(0,y.Cb)({readOnly:!0})],d.prototype,"legendEnabled",null),(0,s._)([(0,y.Cb)({type:Boolean,readOnly:!0})],d.prototype,"updating",null),(0,s._)([(0,y.Cb)({readOnly:!0})],d.prototype,"updatingProgress",null),(0,s._)([(0,y.Cb)()],d.prototype,"visible",null),d=(0,s._)([(0,V.j)("esri.views.layers.LayerView")],d);var O=d}}]);