"use strict";(self.webpackChunkdashboard=self.webpackChunkdashboard||[]).push([[9969],{69969:(z,B,e)=>{e.r(B),e.d(B,{DropShadow:()=>P});var c=e(12788),p=(e(26436),e(27001)),E=(e(67474),e(36320),e(40150),e(94345),e(82705),e(13006)),F=(e(48082),e(10269));const b=[1,0],v=[0,1];class P{constructor(){this._horizontalBlurFBO=null,this._verticalBlurFBO=null,this._size=[0,0],this._programDesc={blur:{vsPath:"post-processing/drop-shadow",fsPath:"post-processing/blur/gaussianBlur",attributes:new Map([["a_position",0]])},composite:{vsPath:"post-processing/pp",fsPath:"post-processing/drop-shadow/composite",attributes:new Map([["a_position",0]])},blit:{vsPath:"post-processing/pp",fsPath:"post-processing/blit",attributes:new Map([["a_position",0]])}}}dispose(){this._layerFBOTexture&&(this._layerFBOTexture.dispose(),this._layerFBOTexture=null),this._horizontalBlurFBO&&(this._horizontalBlurFBO.dispose(),this._horizontalBlurFBO=null),this._verticalBlurFBO&&(this._verticalBlurFBO.dispose(),this._verticalBlurFBO=null)}draw(a,r,o){const{context:t,state:l,painter:x}=a,{materialManager:O}=x,f=this._programDesc,_=r.width,h=r.height,u=[Math.round(_/2),Math.round(h/2)],{blurRadius:g,offsetX:w,offsetY:D,color:i}=o,U=[(0,c.F2)(w/2),(0,c.F2)(D/2)];this._createOrResizeResources(a,_,h,u);const T=this._horizontalBlurFBO,m=this._verticalBlurFBO;t.setStencilWriteMask(0),t.setStencilTestEnabled(!1),t.setDepthWriteEnabled(!1),t.setDepthTestEnabled(!1);const M=this._layerFBOTexture;r.copyToTexture(0,0,_,h,0,0,M),this._quad||(this._quad=new F.Z(t,[-1,-1,1,-1,-1,1,1,1])),t.setViewport(0,0,u[0],u[1]);const n=this._quad;n.bind(),t.setBlendingEnabled(!1);const s=O.getProgram(a,f.blur,[{name:"radius",value:Math.ceil(g)}]);t.useProgram(s),t.bindFramebuffer(T),t.bindTexture(r.colorTexture,4),s.setUniformMatrix3fv("u_displayViewMat3",l.displayMat3),s.setUniform2fv("u_offset",U),s.setUniform1i("u_colorTexture",4),s.setUniform2fv("u_texSize",u),s.setUniform2fv("u_direction",b),s.setUniform1f("u_sigma",g),n.draw(),t.bindFramebuffer(m),t.bindTexture(T.colorTexture,5),s.setUniformMatrix3fv("u_displayViewMat3",l.displayMat3),s.setUniform2fv("u_offset",[0,0]),s.setUniform1i("u_colorTexture",5),s.setUniform2fv("u_direction",v),n.draw(),t.bindFramebuffer(r),t.setViewport(0,0,_,h);const d=O.getProgram(a,f.composite);t.useProgram(d),t.bindTexture(m.colorTexture,2),d.setUniform1i("u_blurTexture",2),t.bindTexture(M,3),d.setUniform1i("u_layerFBOTexture",3),d.setUniform4fv("u_shadowColor",[i[3]*(i[0]/255),i[3]*(i[1]/255),i[3]*(i[2]/255),i[3]]),n.draw(),t.setBlendingEnabled(!0),t.setStencilTestEnabled(!0),t.setBlendFunction(1,771),n.unbind()}_createOrResizeResources(a,r,o,t){const{context:l}=a;this._horizontalBlurFBO&&this._size[0]===r&&this._size[1]===o||(this._size[0]=r,this._size[1]=o,this._horizontalBlurFBO?this._horizontalBlurFBO.resize(t[0],t[1]):this._horizontalBlurFBO=new p.Z(l,{colorTarget:0,depthStencilTarget:0,width:t[0],height:t[1]},{target:3553,pixelFormat:6408,internalFormat:6408,dataType:5121,wrapMode:33071,samplingMode:9729,flipped:!1,width:t[0],height:t[1]}),this._verticalBlurFBO?this._verticalBlurFBO.resize(t[0],t[1]):this._verticalBlurFBO=new p.Z(l,{colorTarget:0,depthStencilTarget:0,width:t[0],height:t[1]},{target:3553,pixelFormat:6408,internalFormat:6408,dataType:5121,wrapMode:33071,samplingMode:9729,flipped:!1,width:t[0],height:t[1]}),this._layerFBOTexture?this._layerFBOTexture.resize(r,o):this._layerFBOTexture=new E.Z(l,{target:3553,pixelFormat:6408,internalFormat:6408,dataType:5121,wrapMode:33071,samplingMode:9729,flipped:!1,width:r,height:o}))}}}}]);