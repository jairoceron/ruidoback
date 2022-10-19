"use strict";var yo=Object.defineProperty,Eo=Object.defineProperties,Co=Object.getOwnPropertyDescriptors,Zr=Object.getOwnPropertySymbols,Po=Object.prototype.hasOwnProperty,So=Object.prototype.propertyIsEnumerable,Kt=Math.pow,kr=(me,$,v)=>$ in me?yo(me,$,{enumerable:!0,configurable:!0,writable:!0,value:v}):me[$]=v,Lt=(me,$)=>{for(var v in $||($={}))Po.call($,v)&&kr(me,v,$[v]);if(Zr)for(var v of Zr($))So.call($,v)&&kr(me,v,$[v]);return me},or=(me,$)=>Eo(me,Co($));(self.webpackChunkdashboard=self.webpackChunkdashboard||[]).push([[9578],{61292:(me,$,v)=>{v.d($,{D:()=>we,b:()=>ce});var C=v(32001),W=v(34270),y=v(52148),I=v(62111),U=v(2970),B=v(54237),P=v(91859),T=v(37928),O=v(19924),x=v(21273),M=v(77461),G=v(92849),k=v(75798),K=v(25583),Y=v(9550),ne=v(66378),q=v(78498),se=v(70946),Pe=v(73403),Ke=v(87954),Re=v(51277),$e=v(98845),Te=v(73184),ft=v(38238),dt=v(72555),We=v(97288),ie=v(97561),de=v(28763);function ce(ee){const ue=new de.kG,tt=ue.vertex.code,nt=ue.fragment.code;return ue.include(dt.a,{name:"Default Material Shader",output:ee.output}),ue.vertex.uniforms.add("proj","mat4").add("view","mat4").add("camPos","vec3").add("localOrigin","vec3"),ue.include(P.f),ue.varyings.add("vpos","vec3"),ue.include(Te.kl,ee),ue.include(U.f,ee),ue.include(G.LC,ee),0!==ee.output&&7!==ee.output||(ue.include(B.O,ee),ue.include(I.w,{linearDepth:!1}),0===ee.normalType&&ee.offsetBackfaces&&ue.include(W.w),ue.include(Y.Q,ee),ue.include(M.B,ee),ee.instancedColor&&ue.attributes.add("instanceColor","vec4"),ue.varyings.add("localvpos","vec3"),ue.include(O.D,ee),ue.include(C.q,ee),ue.include(T.R,ee),ue.include(x.c,ee),ue.vertex.uniforms.add("externalColor","vec4"),ue.varyings.add("vcolorExt","vec4"),ee.multipassTerrainEnabled&&ue.varyings.add("depth","float"),tt.add(ie.H`
      void main(void) {
        forwardNormalizedVertexColor();
        vcolorExt = externalColor;
        ${ee.instancedColor?"vcolorExt *= instanceColor;":""}
        vcolorExt *= vvColor();
        vcolorExt *= getSymbolColor();
        forwardColorMixMode();

        if (vcolorExt.a < ${ie.H.float(ft.bf)}) {
          gl_Position = vec4(1e38, 1e38, 1e38, 1.0);
        }
        else {
          vpos = calculateVPos();
          localvpos = vpos - view[3].xyz;
          vpos = subtractOrigin(vpos);
          ${0===ee.normalType?ie.H`
          vNormalWorld = dpNormal(vvLocalNormal(normalModel()));`:""}
          vpos = addVerticalOffset(vpos, localOrigin);
          ${ee.vertexTangents?"vTangent = dpTransformVertexTangent(tangent);":""}
          gl_Position = transformPosition(proj, view, vpos);
          ${0===ee.normalType&&ee.offsetBackfaces?"gl_Position = offsetBackfacingClipPosition(gl_Position, vpos, vNormalWorld, camPos);":""}
        }

        ${ee.multipassTerrainEnabled?"depth = (view * vec4(vpos, 1.0)).z;":""}
        forwardLinearDepth();
        forwardTextureCoordinates();
      }
    `)),7===ee.output&&(ue.include(y.p2,ee),ue.include(ft.sj,ee),ee.multipassTerrainEnabled&&(ue.fragment.include(K.S),ue.include(se.l,ee)),ue.fragment.uniforms.add("camPos","vec3").add("localOrigin","vec3").add("opacity","float").add("layerOpacity","float"),ee.hasColorTexture&&ue.fragment.uniforms.add("tex","sampler2D"),ue.fragment.include(We.y),nt.add(ie.H`
      void main() {
        discardBySlice(vpos);
        ${ee.multipassTerrainEnabled?"terrainDepthTest(gl_FragCoord, depth);":""}
        ${ee.hasColorTexture?ie.H`
        vec4 texColor = texture2D(tex, vuv0);
        ${ee.textureAlphaPremultiplied?"texColor.rgb /= texColor.a;":""}
        discardOrAdjustAlpha(texColor);`:ie.H`vec4 texColor = vec4(1.0);`}
        ${ee.attributeColor?ie.H`
        float opacity_ = layerOpacity * mixExternalOpacity(vColor.a * opacity, texColor.a, vcolorExt.a, int(colorMixMode));`:ie.H`
        float opacity_ = layerOpacity * mixExternalOpacity(opacity, texColor.a, vcolorExt.a, int(colorMixMode));
        `}
        gl_FragColor = vec4(opacity_);
      }
    `)),0===ee.output&&(ue.include(y.p2,ee),ue.include(q.X,ee),ue.include(ne.K,ee),ue.include(ft.sj,ee),ee.receiveShadows&&ue.include($e.hX,ee),ee.multipassTerrainEnabled&&(ue.fragment.include(K.S),ue.include(se.l,ee)),ue.fragment.uniforms.add("camPos","vec3").add("localOrigin","vec3").add("ambient","vec3").add("diffuse","vec3").add("opacity","float").add("layerOpacity","float"),ee.hasColorTexture&&ue.fragment.uniforms.add("tex","sampler2D"),ue.include(Re.jV,ee),ue.include(Ke.T,ee),ue.fragment.include(We.y),ue.include(Pe.k,ee),nt.add(ie.H`
      void main() {
        discardBySlice(vpos);
        ${ee.multipassTerrainEnabled?"terrainDepthTest(gl_FragCoord, depth);":""}
        ${ee.hasColorTexture?ie.H`
        vec4 texColor = texture2D(tex, vuv0);
        ${ee.textureAlphaPremultiplied?"texColor.rgb /= texColor.a;":""}
        discardOrAdjustAlpha(texColor);`:ie.H`vec4 texColor = vec4(1.0);`}
        shadingParams.viewDirection = normalize(vpos - camPos);
        ${3===ee.normalType?ie.H`
        vec3 normal = screenDerivativeNormal(localvpos);`:ie.H`
        shadingParams.normalView = vNormalWorld;
        vec3 normal = shadingNormal(shadingParams);`}
        ${1===ee.pbrMode?"applyPBRFactors();":""}
        float ssao = evaluateAmbientOcclusionInverse();
        ssao *= getBakedOcclusion();

        float additionalAmbientScale = additionalDirectedAmbientLight(vpos + localOrigin);
        vec3 additionalLight = ssao * lightingMainIntensity * additionalAmbientScale * ambientBoostFactor * lightingGlobalFactor;
        ${ee.receiveShadows?"float shadow = readShadowMap(vpos, linearDepth);":1===ee.viewingMode?"float shadow = lightingGlobalFactor * (1.0 - additionalAmbientScale);":"float shadow = 0.0;"}
        vec3 matColor = max(ambient, diffuse);
        ${ee.attributeColor?ie.H`
        vec3 albedo_ = mixExternalColor(vColor.rgb * matColor, texColor.rgb, vcolorExt.rgb, int(colorMixMode));
        float opacity_ = layerOpacity * mixExternalOpacity(vColor.a * opacity, texColor.a, vcolorExt.a, int(colorMixMode));`:ie.H`
        vec3 albedo_ = mixExternalColor(matColor, texColor.rgb, vcolorExt.rgb, int(colorMixMode));
        float opacity_ = layerOpacity * mixExternalOpacity(opacity, texColor.a, vcolorExt.a, int(colorMixMode));
        `}
        ${ee.hasNormalTexture?ie.H`
              mat3 tangentSpace = ${ee.vertexTangents?"computeTangentSpace(normal);":"computeTangentSpace(normal, vpos, vuv0);"}
              vec3 shadedNormal = computeTextureNormal(tangentSpace, vuv0);`:"vec3 shadedNormal = normal;"}
        ${1===ee.pbrMode||2===ee.pbrMode?1===ee.viewingMode?ie.H`vec3 normalGround = normalize(vpos + localOrigin);`:ie.H`vec3 normalGround = vec3(0.0, 0.0, 1.0);`:ie.H``}
        ${1===ee.pbrMode||2===ee.pbrMode?ie.H`
            float additionalAmbientIrradiance = additionalAmbientIrradianceFactor * lightingMainIntensity[2];
            vec3 shadedColor = evaluateSceneLightingPBR(shadedNormal, albedo_, shadow, 1.0 - ssao, additionalLight, shadingParams.viewDirection, normalGround, mrr, emission, additionalAmbientIrradiance);`:"vec3 shadedColor = evaluateSceneLighting(shadedNormal, albedo_, shadow, 1.0 - ssao, additionalLight);"}
        gl_FragColor = highlightSlice(vec4(shadedColor, opacity_), vpos);
        ${ee.OITEnabled?"gl_FragColor = premultiplyAlpha(gl_FragColor);":""}
      }
    `)),ue.include(k.s,ee),ue}var we=Object.freeze({__proto__:null,build:ce})},52119:(me,$,v)=>{v.d($,{R:()=>We,b:()=>dt});var C=v(32001),W=v(34270),y=v(52148),I=v(62111),U=v(2970),B=v(54237),P=v(91859),T=v(37928),O=v(19924),x=v(21273),M=v(92849),G=v(75798),k=v(25583),K=v(66378),Y=v(78498),ne=v(70946),q=v(87954),se=v(51277),Pe=v(98845),Ke=v(73184),Re=v(38238),$e=v(97288),Te=v(97561),ft=v(28763);function dt(ie){const de=new ft.kG,ce=de.vertex.code,we=de.fragment.code;return de.vertex.uniforms.add("proj","mat4").add("view","mat4").add("camPos","vec3").add("localOrigin","vec3"),de.include(P.f),de.varyings.add("vpos","vec3"),de.include(Ke.kl,ie),de.include(U.f,ie),de.include(M.LC,ie),0!==ie.output&&7!==ie.output||(de.include(B.O,ie),de.include(I.w,{linearDepth:!1}),ie.offsetBackfaces&&de.include(W.w),ie.instancedColor&&de.attributes.add("instanceColor","vec4"),de.varyings.add("vNormalWorld","vec3"),de.varyings.add("localvpos","vec3"),ie.multipassTerrainEnabled&&de.varyings.add("depth","float"),de.include(O.D,ie),de.include(C.q,ie),de.include(T.R,ie),de.include(x.c,ie),de.vertex.uniforms.add("externalColor","vec4"),de.varyings.add("vcolorExt","vec4"),ce.add(Te.H`
        void main(void) {
          forwardNormalizedVertexColor();
          vcolorExt = externalColor;
          ${ie.instancedColor?"vcolorExt *= instanceColor;":""}
          vcolorExt *= vvColor();
          vcolorExt *= getSymbolColor();
          forwardColorMixMode();

          if (vcolorExt.a < ${Te.H.float(Re.bf)}) {
            gl_Position = vec4(1e38, 1e38, 1e38, 1.0);
          }
          else {
            vpos = calculateVPos();
            localvpos = vpos - view[3].xyz;
            vpos = subtractOrigin(vpos);
            vNormalWorld = dpNormal(vvLocalNormal(normalModel()));
            vpos = addVerticalOffset(vpos, localOrigin);
            gl_Position = transformPosition(proj, view, vpos);
            ${ie.offsetBackfaces?"gl_Position = offsetBackfacingClipPosition(gl_Position, vpos, vNormalWorld, camPos);":""}
          }
          ${ie.multipassTerrainEnabled?Te.H`depth = (view * vec4(vpos, 1.0)).z;`:""}
          forwardLinearDepth();
          forwardTextureCoordinates();
        }
      `)),7===ie.output&&(de.include(y.p2,ie),de.include(Re.sj,ie),ie.multipassTerrainEnabled&&(de.fragment.include(k.S),de.include(ne.l,ie)),de.fragment.uniforms.add("camPos","vec3").add("localOrigin","vec3").add("opacity","float").add("layerOpacity","float"),de.fragment.uniforms.add("view","mat4"),ie.hasColorTexture&&de.fragment.uniforms.add("tex","sampler2D"),de.fragment.include($e.y),we.add(Te.H`
      void main() {
        discardBySlice(vpos);
        ${ie.multipassTerrainEnabled?Te.H`terrainDepthTest(gl_FragCoord, depth);`:""}
        ${ie.hasColorTexture?Te.H`
        vec4 texColor = texture2D(tex, vuv0);
        ${ie.textureAlphaPremultiplied?"texColor.rgb /= texColor.a;":""}
        discardOrAdjustAlpha(texColor);`:Te.H`vec4 texColor = vec4(1.0);`}
        ${ie.attributeColor?Te.H`
        float opacity_ = layerOpacity * mixExternalOpacity(vColor.a * opacity, texColor.a, vcolorExt.a, int(colorMixMode));`:Te.H`
        float opacity_ = layerOpacity * mixExternalOpacity(opacity, texColor.a, vcolorExt.a, int(colorMixMode));
        `}

        gl_FragColor = vec4(opacity_);
      }
    `)),0===ie.output&&(de.include(y.p2,ie),de.include(Y.X,ie),de.include(K.K,ie),de.include(Re.sj,ie),ie.receiveShadows&&de.include(Pe.hX,ie),ie.multipassTerrainEnabled&&(de.fragment.include(k.S),de.include(ne.l,ie)),de.fragment.uniforms.add("camPos","vec3").add("localOrigin","vec3").add("ambient","vec3").add("diffuse","vec3").add("opacity","float").add("layerOpacity","float"),de.fragment.uniforms.add("view","mat4"),ie.hasColorTexture&&de.fragment.uniforms.add("tex","sampler2D"),de.include(se.jV,ie),de.include(q.T,ie),de.fragment.include($e.y),we.add(Te.H`
      void main() {
        discardBySlice(vpos);
        ${ie.multipassTerrainEnabled?Te.H`terrainDepthTest(gl_FragCoord, depth);`:""}
        ${ie.hasColorTexture?Te.H`
        vec4 texColor = texture2D(tex, vuv0);
        ${ie.textureAlphaPremultiplied?"texColor.rgb /= texColor.a;":""}
        discardOrAdjustAlpha(texColor);`:Te.H`vec4 texColor = vec4(1.0);`}
        vec3 viewDirection = normalize(vpos - camPos);
        ${1===ie.pbrMode?"applyPBRFactors();":""}
        float ssao = evaluateAmbientOcclusionInverse();
        ssao *= getBakedOcclusion();

        float additionalAmbientScale = additionalDirectedAmbientLight(vpos + localOrigin);
        vec3 additionalLight = ssao * lightingMainIntensity * additionalAmbientScale * ambientBoostFactor * lightingGlobalFactor;
        ${ie.receiveShadows?"float shadow = readShadowMap(vpos, linearDepth);":1===ie.viewingMode?"float shadow = lightingGlobalFactor * (1.0 - additionalAmbientScale);":"float shadow = 0.0;"}
        vec3 matColor = max(ambient, diffuse);
        ${ie.attributeColor?Te.H`
        vec3 albedo_ = mixExternalColor(vColor.rgb * matColor, texColor.rgb, vcolorExt.rgb, int(colorMixMode));
        float opacity_ = layerOpacity * mixExternalOpacity(vColor.a * opacity, texColor.a, vcolorExt.a, int(colorMixMode));`:Te.H`
        vec3 albedo_ = mixExternalColor(matColor, texColor.rgb, vcolorExt.rgb, int(colorMixMode));
        float opacity_ = layerOpacity * mixExternalOpacity(opacity, texColor.a, vcolorExt.a, int(colorMixMode));
        `}
        ${Te.H`
        vec3 shadedNormal = normalize(vNormalWorld);
        albedo_ *= 1.2;
        vec3 viewForward = vec3(view[0][2], view[1][2], view[2][2]);
        float alignmentLightView = clamp(dot(viewForward, -lightingMainDirection), 0.0, 1.0);
        float transmittance = 1.0 - clamp(dot(viewForward, shadedNormal), 0.0, 1.0);
        float treeRadialFalloff = vColor.r;
        float backLightFactor = 0.5 * treeRadialFalloff * alignmentLightView * transmittance * (1.0 - shadow);
        additionalLight += backLightFactor * lightingMainIntensity;`}
        ${1===ie.pbrMode||2===ie.pbrMode?1===ie.viewingMode?Te.H`vec3 normalGround = normalize(vpos + localOrigin);`:Te.H`vec3 normalGround = vec3(0.0, 0.0, 1.0);`:Te.H``}
        ${1===ie.pbrMode||2===ie.pbrMode?Te.H`
            float additionalAmbientIrradiance = additionalAmbientIrradianceFactor * lightingMainIntensity[2];
            vec3 shadedColor = evaluateSceneLightingPBR(shadedNormal, albedo_, shadow, 1.0 - ssao, additionalLight, viewDirection, normalGround, mrr, emission, additionalAmbientIrradiance);`:"vec3 shadedColor = evaluateSceneLighting(shadedNormal, albedo_, shadow, 1.0 - ssao, additionalLight);"}
        gl_FragColor = highlightSlice(vec4(shadedColor, opacity_), vpos);
        ${ie.OITEnabled?"gl_FragColor = premultiplyAlpha(gl_FragColor);":""}
      }
    `)),de.include(G.s,ie),de}var We=Object.freeze({__proto__:null,build:dt})},25461:(me,$,v)=>{function C(){return[1,0,0,0,1,0,0,0,1]}function I(B,P){return new Float64Array(B,P,9)}v.d($,{a:()=>I,c:()=>C}),Object.freeze({__proto__:null,create:C,clone:function(B){return[B[0],B[1],B[2],B[3],B[4],B[5],B[6],B[7],B[8]]},fromValues:function(B,P,T,O,x,M,G,k,K){return[B,P,T,O,x,M,G,k,K]},createView:I})},4003:(me,$,v)=>{function C(){return[1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1]}function W(P){return[P[0],P[1],P[2],P[3],P[4],P[5],P[6],P[7],P[8],P[9],P[10],P[11],P[12],P[13],P[14],P[15]]}function I(P,T){return new Float64Array(P,T,16)}v.d($,{I:()=>U,a:()=>I,b:()=>W,c:()=>C});const U=[1,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1];Object.freeze({__proto__:null,create:C,clone:W,fromValues:function(P,T,O,x,M,G,k,K,Y,ne,q,se,Pe,Ke,Re,$e){return[P,T,O,x,M,G,k,K,Y,ne,q,se,Pe,Ke,Re,$e]},createView:I,IDENTITY:U})},38203:(me,$,v)=>{v.d($,{c:()=>se,g:()=>O,j:()=>nt,k:()=>Ke,m:()=>x,s:()=>T});var C=v(25461),W=v(9334),y=v(10127),I=v(65566),U=v(6618),B=v(75660);function T(A,D,H){H*=.5;const N=Math.sin(H);return A[0]=N*D[0],A[1]=N*D[1],A[2]=N*D[2],A[3]=Math.cos(H),A}function O(A,D){const H=2*Math.acos(D[3]),N=Math.sin(H/2);return N>I.E?(A[0]=D[0]/N,A[1]=D[1]/N,A[2]=D[2]/N):(A[0]=1,A[1]=0,A[2]=0),H}function x(A,D,H){const N=D[0],Q=D[1],te=D[2],ge=D[3],fe=H[0],xe=H[1],He=H[2],ze=H[3];return A[0]=N*ze+ge*fe+Q*He-te*xe,A[1]=Q*ze+ge*xe+te*fe-N*He,A[2]=te*ze+ge*He+N*xe-Q*fe,A[3]=ge*ze-N*fe-Q*xe-te*He,A}function Y(A,D,H,N){const Q=D[0],te=D[1],ge=D[2],fe=D[3];let xe,He,ze,Qe,F,z=H[0],j=H[1],Z=H[2],le=H[3];return He=Q*z+te*j+ge*Z+fe*le,He<0&&(He=-He,z=-z,j=-j,Z=-Z,le=-le),1-He>I.E?(xe=Math.acos(He),ze=Math.sin(xe),Qe=Math.sin((1-N)*xe)/ze,F=Math.sin(N*xe)/ze):(Qe=1-N,F=N),A[0]=Qe*Q+F*z,A[1]=Qe*te+F*j,A[2]=Qe*ge+F*Z,A[3]=Qe*fe+F*le,A}function se(A,D){return A[0]=-D[0],A[1]=-D[1],A[2]=-D[2],A[3]=D[3],A}function Pe(A,D){const H=D[0]+D[4]+D[8];let N;if(H>0)N=Math.sqrt(H+1),A[3]=.5*N,N=.5/N,A[0]=(D[5]-D[7])*N,A[1]=(D[6]-D[2])*N,A[2]=(D[1]-D[3])*N;else{let Q=0;D[4]>D[0]&&(Q=1),D[8]>D[3*Q+Q]&&(Q=2);const te=(Q+1)%3,ge=(Q+2)%3;N=Math.sqrt(D[3*Q+Q]-D[3*te+te]-D[3*ge+ge]+1),A[Q]=.5*N,N=.5/N,A[3]=(D[3*te+ge]-D[3*ge+te])*N,A[te]=(D[3*te+Q]+D[3*Q+te])*N,A[ge]=(D[3*ge+Q]+D[3*Q+ge])*N}return A}function Ke(A,D,H,N){const Q=.5*Math.PI/180;D*=Q,H*=Q,N*=Q;const te=Math.sin(D),ge=Math.cos(D),fe=Math.sin(H),xe=Math.cos(H),He=Math.sin(N),ze=Math.cos(N);return A[0]=te*xe*ze-ge*fe*He,A[1]=ge*fe*ze+te*xe*He,A[2]=ge*xe*He-te*fe*ze,A[3]=ge*xe*ze+te*fe*He,A}const $e=B.c,Te=B.s,ft=B.a,dt=x,We=B.b,ie=B.d,de=B.l,ce=B.e,we=ce,ee=B.f,ue=ee,tt=B.n,nt=B.g,ut=B.h,Ee=(0,y.c)(),Ye=(0,y.f)(1,0,0),Tt=(0,y.f)(0,1,0),bt=(0,W.a)(),Et=(0,W.a)(),b=(0,C.c)();Object.freeze({__proto__:null,identity:function(A){return A[0]=0,A[1]=0,A[2]=0,A[3]=1,A},setAxisAngle:T,getAxisAngle:O,multiply:x,rotateX:function(A,D,H){H*=.5;const N=D[0],Q=D[1],te=D[2],ge=D[3],fe=Math.sin(H),xe=Math.cos(H);return A[0]=N*xe+ge*fe,A[1]=Q*xe+te*fe,A[2]=te*xe-Q*fe,A[3]=ge*xe-N*fe,A},rotateY:function(A,D,H){H*=.5;const N=D[0],Q=D[1],te=D[2],ge=D[3],fe=Math.sin(H),xe=Math.cos(H);return A[0]=N*xe-te*fe,A[1]=Q*xe+ge*fe,A[2]=te*xe+N*fe,A[3]=ge*xe-Q*fe,A},rotateZ:function(A,D,H){H*=.5;const N=D[0],Q=D[1],te=D[2],ge=D[3],fe=Math.sin(H),xe=Math.cos(H);return A[0]=N*xe+Q*fe,A[1]=Q*xe-N*fe,A[2]=te*xe+ge*fe,A[3]=ge*xe-te*fe,A},calculateW:function(A,D){const H=D[0],N=D[1],Q=D[2];return A[0]=H,A[1]=N,A[2]=Q,A[3]=Math.sqrt(Math.abs(1-H*H-N*N-Q*Q)),A},slerp:Y,random:function(A){const D=(0,I.R)(),H=(0,I.R)(),N=(0,I.R)(),Q=Math.sqrt(1-D),te=Math.sqrt(D);return A[0]=Q*Math.sin(2*Math.PI*H),A[1]=Q*Math.cos(2*Math.PI*H),A[2]=te*Math.sin(2*Math.PI*N),A[3]=te*Math.cos(2*Math.PI*N),A},invert:function(A,D){const H=D[0],N=D[1],Q=D[2],te=D[3],ge=H*H+N*N+Q*Q+te*te,fe=ge?1/ge:0;return A[0]=-H*fe,A[1]=-N*fe,A[2]=-Q*fe,A[3]=te*fe,A},conjugate:se,fromMat3:Pe,fromEuler:Ke,str:function(A){return"quat("+A[0]+", "+A[1]+", "+A[2]+", "+A[3]+")"},copy:$e,set:Te,add:ft,mul:dt,scale:We,dot:ie,lerp:de,length:ce,len:we,squaredLength:ee,sqrLen:ue,normalize:tt,exactEquals:nt,equals:ut,rotationTo:function(A,D,H){const N=(0,U.d)(D,H);return N<-.999999?((0,U.c)(Ee,Ye,D),(0,U.u)(Ee)<1e-6&&(0,U.c)(Ee,Tt,D),(0,U.n)(Ee,Ee),T(A,Ee,Math.PI),A):N>.999999?(A[0]=0,A[1]=0,A[2]=0,A[3]=1,A):((0,U.c)(Ee,D,H),A[0]=Ee[0],A[1]=Ee[1],A[2]=Ee[2],A[3]=1+N,tt(A,A))},sqlerp:function(A,D,H,N,Q,te){return Y(bt,D,Q,te),Y(Et,H,N,te),Y(A,bt,Et,2*te*(1-te)),A},setAxes:function(A,D,H,N){const Q=b;return Q[0]=H[0],Q[3]=H[1],Q[6]=H[2],Q[1]=N[0],Q[4]=N[1],Q[7]=N[2],Q[2]=-D[0],Q[5]=-D[1],Q[8]=-D[2],tt(A,Pe(A,Q))}})},9334:(me,$,v)=>{function C(){return[0,0,0,1]}function W(P){return[P[0],P[1],P[2],P[3]]}function I(P,T){return new Float64Array(P,T,4)}v.d($,{I:()=>U,a:()=>C,b:()=>W,c:()=>I});const U=[0,0,0,1];Object.freeze({__proto__:null,create:C,clone:W,fromValues:function(P,T,O,x){return[P,T,O,x]},createView:I,IDENTITY:U})},55693:(me,$,v)=>{v.d($,{a:()=>y,b:()=>B,n:()=>U,s:()=>I,t:()=>W});var C=v(35642);function W(T,O,x){if(T.count!==O.count)return void C.k.error("source and destination buffers need to have the same number of elements");const M=T.count,G=x[0],k=x[1],K=x[2],Y=x[4],ne=x[5],q=x[6],se=x[8],Pe=x[9],Ke=x[10],Re=x[12],$e=x[13],Te=x[14],ft=T.typedBuffer,dt=T.typedBufferStride,We=O.typedBuffer,ie=O.typedBufferStride;for(let de=0;de<M;de++){const ce=de*dt,we=de*ie,ee=We[we],ue=We[we+1],tt=We[we+2];ft[ce]=G*ee+Y*ue+se*tt+Re,ft[ce+1]=k*ee+ne*ue+Pe*tt+$e,ft[ce+2]=K*ee+q*ue+Ke*tt+Te}}function y(T,O,x){if(T.count!==O.count)return void C.k.error("source and destination buffers need to have the same number of elements");const M=T.count,G=x[0],k=x[1],K=x[2],Y=x[3],ne=x[4],q=x[5],se=x[6],Pe=x[7],Ke=x[8],Re=T.typedBuffer,$e=T.typedBufferStride,Te=O.typedBuffer,ft=O.typedBufferStride;for(let dt=0;dt<M;dt++){const We=dt*$e,ie=dt*ft,de=Te[ie],ce=Te[ie+1],we=Te[ie+2];Re[We]=G*de+Y*ce+se*we,Re[We+1]=k*de+ne*ce+Pe*we,Re[We+2]=K*de+q*ce+Ke*we}}function I(T,O,x){const M=Math.min(T.count,O.count),G=T.typedBuffer,k=T.typedBufferStride,K=O.typedBuffer,Y=O.typedBufferStride;for(let ne=0;ne<M;ne++){const q=ne*k,se=ne*Y;G[q]=x*K[se],G[q+1]=x*K[se+1],G[q+2]=x*K[se+2]}}function U(T,O){const x=Math.min(T.count,O.count),M=T.typedBuffer,G=T.typedBufferStride,k=O.typedBuffer,K=O.typedBufferStride;for(let Y=0;Y<x;Y++){const ne=Y*G,q=Y*K,se=k[q],Pe=k[q+1],Ke=k[q+2],Re=Math.sqrt(se*se+Pe*Pe+Ke*Ke);if(Re>0){const $e=1/Re;M[ne]=$e*se,M[ne+1]=$e*Pe,M[ne+2]=$e*Ke}}}function B(T,O,x){const M=Math.min(T.count,O.count),G=T.typedBuffer,k=T.typedBufferStride,K=O.typedBuffer,Y=O.typedBufferStride;for(let ne=0;ne<M;ne++){const q=ne*k,se=ne*Y;G[q]=K[se]>>x,G[q+1]=K[se+1]>>x,G[q+2]=K[se+2]>>x}}Object.freeze({__proto__:null,transformMat4:W,transformMat3:y,scale:I,normalize:U,shiftRight:B})},52055:(me,$,v)=>{function C(I,U,B){const P=I.typedBuffer,T=I.typedBufferStride,O=U.typedBuffer,x=U.typedBufferStride,M=B?B.count:U.count;let G=(B&&B.dstIndex?B.dstIndex:0)*T,k=(B&&B.srcIndex?B.srcIndex:0)*x;for(let K=0;K<M;++K)P[G]=O[k],P[G+1]=O[k+1],P[G+2]=O[k+2],G+=T,k+=x}function W(I,U,B,P,T){var O,x;const M=I.typedBuffer,G=I.typedBufferStride,k=null!=(O=null==T?void 0:T.count)?O:I.count;let K=(null!=(x=null==T?void 0:T.dstIndex)?x:0)*G;for(let Y=0;Y<k;++Y)M[K]=U,M[K+1]=B,M[K+2]=P,K+=G}v.d($,{c:()=>C,f:()=>W}),Object.freeze({__proto__:null,copy:C,fill:W})},35642:(me,$,v)=>{v.d($,{k:()=>W});const W=v(33870).Z.getLogger("esri.views.3d.support.buffer.math")},89578:(me,$,v)=>{v.r($),v.d($,{fetch:()=>_o,gltfToEngineResources:()=>fr,parseUrl:()=>Xr});var C=v(61921),W=v(67492),y=v(60305),I=v(19554),U=v(25461),B=v(88034),P=v(4003),T=v(6618),O=v(10127),x=v(53781),M=v(56626),G=v(55693),k=v(24164),K=v(71351),Y=v(74924),ne=v(30934),q=v(40873),se=v(40662),Pe=v(50898),Ke=v(22795),Re=v(33870),$e=v(12523),Te=v(25503),ft=v(94226),dt=v(33828),We=v(48557);class ie{constructor(l,d,m,_){this.primitiveIndices=l,this._numIndexPerPrimitive=d,this.indices=m,this.position=_,this.center=(0,O.c)(),(0,We.hu)(l.length>=1),(0,We.hu)(m.length%this._numIndexPerPrimitive==0),(0,We.hu)(m.length>=l.length*this._numIndexPerPrimitive),(0,We.hu)(3===_.size||4===_.size);const{data:E,size:S}=_,L=l.length;let R=S*m[this._numIndexPerPrimitive*l[0]];de.clear(),de.push(R),this.bbMin=(0,O.f)(E[R],E[R+1],E[R+2]),this.bbMax=(0,O.a)(this.bbMin);for(let re=0;re<L;++re){const ve=this._numIndexPerPrimitive*l[re];for(let oe=0;oe<this._numIndexPerPrimitive;++oe){R=S*m[ve+oe],de.push(R);let Me=E[R];this.bbMin[0]=Math.min(Me,this.bbMin[0]),this.bbMax[0]=Math.max(Me,this.bbMax[0]),Me=E[R+1],this.bbMin[1]=Math.min(Me,this.bbMin[1]),this.bbMax[1]=Math.max(Me,this.bbMax[1]),Me=E[R+2],this.bbMin[2]=Math.min(Me,this.bbMin[2]),this.bbMax[2]=Math.max(Me,this.bbMax[2])}}(0,T.e)(this.center,this.bbMin,this.bbMax,.5),this.radius=.5*Math.max(Math.max(this.bbMax[0]-this.bbMin[0],this.bbMax[1]-this.bbMin[1]),this.bbMax[2]-this.bbMin[2]);let w=this.radius*this.radius;for(let re=0;re<de.length;++re){R=de.getItemAt(re);const ve=E[R]-this.center[0],oe=E[R+1]-this.center[1],Me=E[R+2]-this.center[2],J=ve*ve+oe*oe+Me*Me;if(J<=w)continue;const Oe=Math.sqrt(J),Ie=.5*(Oe-this.radius);this.radius=this.radius+Ie,w=this.radius*this.radius;const Ve=Ie/Oe;this.center[0]+=ve*Ve,this.center[1]+=oe*Ve,this.center[2]+=Me*Ve}de.clear()}getCenter(){return this.center}getBSRadius(){return this.radius}getBBMin(){return this.bbMin}getBBMax(){return this.bbMax}getChildren(){if(this._children)return this._children;if((0,T.h)(this.bbMin,this.bbMax)>1){const l=(0,T.e)((0,O.c)(),this.bbMin,this.bbMax,.5),d=this.primitiveIndices.length,m=new Uint8Array(d),_=new Array(8);for(let w=0;w<8;++w)_[w]=0;const{data:E,size:S}=this.position;for(let w=0;w<d;++w){let re=0;const ve=this._numIndexPerPrimitive*this.primitiveIndices[w];let oe=S*this.indices[ve],Me=E[oe],J=E[oe+1],Oe=E[oe+2];for(let Ie=1;Ie<this._numIndexPerPrimitive;++Ie){oe=S*this.indices[ve+Ie];const Ve=E[oe],mt=E[oe+1],rt=E[oe+2];Ve<Me&&(Me=Ve),mt<J&&(J=mt),rt<Oe&&(Oe=rt)}Me<l[0]&&(re|=1),J<l[1]&&(re|=2),Oe<l[2]&&(re|=4),m[w]=re,++_[re]}let L=0;for(let w=0;w<8;++w)_[w]>0&&++L;if(L<2)return;const R=new Array(8);for(let w=0;w<8;++w)R[w]=_[w]>0?new Uint32Array(_[w]):void 0;for(let w=0;w<8;++w)_[w]=0;for(let w=0;w<d;++w){const re=m[w];R[re][_[re]++]=this.primitiveIndices[w]}this._children=new Array(8);for(let w=0;w<8;++w)void 0!==R[w]&&(this._children[w]=new ie(R[w],this._numIndexPerPrimitive,this.indices,this.position))}return this._children}static prune(){de.prune()}}const de=new dt.Z({deallocator:null});var ce=v(9962);class we{constructor(){this.id=(0,ce.D)()}unload(){}}var ee=v(71857);class ue extends we{constructor(l,d=[],m=0,_=-1){super(),this._primitiveType=m,this.edgeIndicesLength=_,this.type=2,this._vertexAttributes=new Map,this._indices=new Map,this._boundingInfo=null;for(const[E,S]of l)S&&this._vertexAttributes.set(E,Lt({},S));if(null==d||0===d.length){const E=function(p){const l=p.values().next().value;return null==l?0:l.data.length/l.size}(this._vertexAttributes),S=(0,ee.p)(E);this.edgeIndicesLength=this.edgeIndicesLength<0?E:this.edgeIndicesLength;for(const L of this._vertexAttributes.keys())this._indices.set(L,S)}else for(const[E,S]of d)S&&(this._indices.set(E,nt(S)),"position"===E&&(this.edgeIndicesLength=this.edgeIndicesLength<0?this._indices.get(E).length:this.edgeIndicesLength))}get vertexAttributes(){return this._vertexAttributes}getMutableAttribute(l){const d=this._vertexAttributes.get(l);return d&&!d.exclusive&&(d.data=Array.from(d.data),d.exclusive=!0),d}get indices(){return this._indices}get indexCount(){const l=this._indices.values().next().value;return l?l.length:0}get primitiveType(){return this._primitiveType}get faceCount(){return this.indexCount/3}get boundingInfo(){return(0,y.Wi)(this._boundingInfo)&&(this._boundingInfo=this._calculateBoundingInfo()),this._boundingInfo}computeAttachmentOrigin(l){return 0===this.primitiveType?this.computeAttachmentOriginTriangles(l):this.computeAttachmentOriginPoints(l)}computeAttachmentOriginTriangles(l){const d=this.indices.get("position"),m=this.vertexAttributes.get("position");return(0,ee.cM)(m,d,l)}computeAttachmentOriginPoints(l){const d=this.indices.get("position"),m=this.vertexAttributes.get("position");return(0,ee.NO)(m,d,l)}invalidateBoundingInfo(){this._boundingInfo=null}_calculateBoundingInfo(){const l=this.indices.get("position");if(0===l.length)return null;const d=0===this.primitiveType?3:1;(0,We.hu)(l.length%d==0,"Indexing error: "+l.length+" not divisible by "+d);const m=(0,ee.p)(l.length/d),_=this.vertexAttributes.get("position");return new ie(m,d,l,_)}}function nt(p){if(p.BYTES_PER_ELEMENT===Uint16Array.BYTES_PER_ELEMENT)return p;for(const l of p)if(l>=65536)return p;return new Uint16Array(p)}var ut=v(64465),xt=v(77624),Ee=v(22791),Ye=v(89868),Tt=v(89225),yt=v(60356),bt=v(53181);function Et(){if((0,y.Wi)(V)){const p=l=>(0,bt.V)(`esri/libs/basisu/${l}`);V=v.e(7620).then(v.bind(v,67620)).then(function(l){return l.b}).then(({default:l})=>l({locateFile:p}).then(d=>(d.initializeBasis(),delete d.then,d)))}return V}let V;var b=v(13006),X=v(30070);let A=null,D=null;function H(){return N.apply(this,arguments)}function N(){return(N=(0,C.Z)(function*(){return(0,y.Wi)(D)&&(D=Et(),A=yield D),D})).apply(this,arguments)}function ge(p,l,d,m,_){const E=(0,X.RG)(l?37496:37492),S=_&&p>1?(Kt(4,p)-1)/(3*Kt(4,p-1)):1;return Math.ceil(d*m*E*S)}function fe(p){return p.getNumImages()>=1&&!p.isUASTC()}function xe(p){return p.getFaces()>=1&&p.isETC1S()}function ze(){return(ze=(0,C.Z)(function*(p,l,d){(0,y.Wi)(A)&&(A=yield H());const m=new A.BasisFile(new Uint8Array(d));if(!fe(m))return null;m.startTranscoding();const _=z(p,l,m.getNumLevels(0),m.getHasAlpha(),m.getImageWidth(0,0),m.getImageHeight(0,0),(E,S)=>m.getImageTranscodedSizeInBytes(0,E,S),(E,S,L)=>m.transcodeImage(L,0,E,S,0,0));return m.close(),m.delete(),_})).apply(this,arguments)}function F(){return(F=(0,C.Z)(function*(p,l,d){(0,y.Wi)(A)&&(A=yield H());const m=new A.KTX2File(new Uint8Array(d));if(!xe(m))return null;m.startTranscoding();const _=z(p,l,m.getLevels(),m.getHasAlpha(),m.getWidth(),m.getHeight(),(E,S)=>m.getImageTranscodedSizeInBytes(E,0,0,S),(E,S,L)=>m.transcodeImage(L,E,0,0,S,0,-1,-1));return m.close(),m.delete(),_})).apply(this,arguments)}function z(p,l,d,m,_,E,S,L){const{compressedTextureETC:R,compressedTextureS3TC:w}=p.capabilities,[re,ve]=R?m?[1,37496]:[0,37492]:w?m?[3,33779]:[2,33776]:[13,6408],oe=l.hasMipmap?d:Math.min(1,d),Me=[];for(let Ve=0;Ve<oe;Ve++)Me.push(new Uint8Array(S(Ve,re))),L(Ve,re,Me[Ve]);const J=Me.length>1,Oe=J?9987:9729,Ie=or(Lt({},l),{samplingMode:Oe,hasMipmap:J,internalFormat:ve,width:_,height:E});return new b.Z(p,Ie,{type:"compressed",levels:Me})}const j=Re.Z.getLogger("esri.views.3d.webgl-engine.lib.DDSUtil");function Ae(p){return p.charCodeAt(0)+(p.charCodeAt(1)<<8)+(p.charCodeAt(2)<<16)+(p.charCodeAt(3)<<24)}const De=Ae("DXT1"),ye=Ae("DXT3"),ae=Ae("DXT5");const vt=new Map([["position",0],["normal",1],["uv0",2],["color",3],["size",4],["tangent",4],["auxpos1",5],["symbolColor",5],["auxpos2",6],["featureAttribute",6],["instanceFeatureAttribute",6],["instanceColor",7],["model",8],["modelNormal",12],["modelOriginHi",11],["modelOriginLo",15]]),Ht=[{name:"position",count:2,type:5126,offset:0,stride:8,normalized:!1}],Nt=[{name:"position",count:2,type:5126,offset:0,stride:16,normalized:!1},{name:"uv0",count:2,type:5126,offset:8,stride:16,normalized:!1}];var Rt=v(26436),Ot=v(48082),Yt=v(27001),Pt=v(70517);class Ge extends we{constructor(l,d){super(),this.data=l,this.type=4,this.glTexture=null,this.powerOfTwoStretchInfo=null,this.loadingPromise=null,this.loadingController=null,this.events=new xt.Z,this.params=d||{},this.params.mipmap=!1!==this.params.mipmap,this.params.noUnpackFlip=this.params.noUnpackFlip||!1,this.params.preMultiplyAlpha=this.params.preMultiplyAlpha||!1,this.params.wrap=this.params.wrap||{s:10497,t:10497},this.params.powerOfTwoResizeMode=this.params.powerOfTwoResizeMode||1,this.estimatedTexMemRequired=Ge.estimateTexMemRequired(this.data,this.params),this.startPreload()}startPreload(){const l=this.data;(0,y.Wi)(l)||(l instanceof HTMLVideoElement?this.startPreloadVideoElement(l):l instanceof HTMLImageElement&&this.startPreloadImageElement(l))}startPreloadVideoElement(l){(0,Tt.jc)(l.src)||"auto"===l.preload&&l.crossOrigin||(l.preload="auto",l.crossOrigin="anonymous",l.src=l.src)}startPreloadImageElement(l){(0,Tt.HK)(l.src)||(0,Tt.jc)(l.src)||l.crossOrigin||(l.crossOrigin="anonymous",l.src=l.src)}static getDataDimensions(l){return l instanceof HTMLVideoElement?{width:l.videoWidth,height:l.videoHeight}:l}static estimateTexMemRequired(l,d){if((0,y.Wi)(l))return 0;if((0,Ye.eP)(l)||(0,Ye.lq)(l))return d.encoding===Ge.KTX2_ENCODING?function(p,l){if((0,y.Wi)(A))return p.byteLength;const d=new A.KTX2File(new Uint8Array(p)),m=xe(d)?ge(d.getLevels(),d.getHasAlpha(),d.getWidth(),d.getHeight(),l):0;return d.close(),d.delete(),m}(l,d.mipmap):d.encoding===Ge.BASIS_ENCODING?function(p,l){if((0,y.Wi)(A))return p.byteLength;const d=new A.BasisFile(new Uint8Array(p)),m=fe(d)?ge(d.getNumLevels(0),d.getHasAlpha(),d.getImageWidth(0,0),d.getImageHeight(0,0),l):0;return d.close(),d.delete(),m}(l,d.mipmap):l.byteLength;const{width:m,height:_}=l instanceof Image||l instanceof ImageData||l instanceof HTMLCanvasElement||l instanceof HTMLVideoElement?Ge.getDataDimensions(l):d;return(d.mipmap?4/3:1)*m*_*(d.components||4)||0}dispose(){this.data=void 0}get width(){return this.params.width}get height(){return this.params.height}createDescriptor(l){var d;return{target:3553,pixelFormat:6408,dataType:5121,wrapMode:this.params.wrap,flipped:!this.params.noUnpackFlip,samplingMode:this.params.mipmap?9987:9729,hasMipmap:this.params.mipmap,preMultiplyAlpha:this.params.preMultiplyAlpha,maxAnisotropy:null!=(d=this.params.maxAnisotropy)?d:this.params.mipmap?l.parameters.maxMaxAnisotropy:1}}load(l,d){if((0,y.pC)(this.glTexture))return this.glTexture;if((0,y.pC)(this.loadingPromise))return this.loadingPromise;const m=this.data;return(0,y.Wi)(m)?(this.glTexture=new b.Z(l,this.createDescriptor(l),null),this.glTexture):"string"==typeof m?this.loadFromURL(l,d,m):m instanceof Image?this.loadFromImageElement(l,d,m):m instanceof HTMLVideoElement?this.loadFromVideoElement(l,d,m):m instanceof ImageData||m instanceof HTMLCanvasElement?this.loadFromImage(l,m,d):((0,Ye.eP)(m)||(0,Ye.lq)(m))&&this.params.encoding===Ge.DDS_ENCODING?this.loadFromDDSData(l,m):((0,Ye.eP)(m)||(0,Ye.lq)(m))&&this.params.encoding===Ge.KTX2_ENCODING?this.loadFromKTX2(l,m):((0,Ye.eP)(m)||(0,Ye.lq)(m))&&this.params.encoding===Ge.BASIS_ENCODING?this.loadFromBasis(l,m):(0,Ye.lq)(m)?this.loadFromPixelData(l,m):(0,Ye.eP)(m)?this.loadFromPixelData(l,new Uint8Array(m)):null}get requiresFrameUpdates(){return this.data instanceof HTMLVideoElement}frameUpdate(l,d,m){if(!(this.data instanceof HTMLVideoElement)||(0,y.Wi)(this.glTexture)||this.data.readyState<2||m===this.data.currentTime)return m;if((0,y.pC)(this.powerOfTwoStretchInfo)){const{framebuffer:_,vao:E,sourceTexture:S}=this.powerOfTwoStretchInfo;S.setData(this.data),this.drawStretchedTexture(l,d,_,E,S,this.glTexture)}else{const{width:_,height:E}=this.data,{width:S,height:L}=this.glTexture.descriptor;_!==S||E!==L?this.glTexture.updateData(0,0,0,Math.min(_,S),Math.min(E,L),this.data):this.glTexture.setData(this.data)}return this.glTexture.descriptor.hasMipmap&&this.glTexture.generateMipmap(),this.data.currentTime}loadFromDDSData(l,d){return this.glTexture=function(p,l,d){const{textureData:m,internalFormat:_,width:E,height:S}=function(p,l){const d=new Int32Array(p,0,31);if(542327876!==d[0])return j.error("Invalid magic number in DDS header"),null;if(!(4&d[20]))return j.error("Unsupported format, must contain a FourCC code"),null;const m=d[21];let _,E;switch(m){case De:_=8,E=33776;break;case ye:_=16,E=33778;break;case ae:_=16,E=33779;break;default:return j.error("Unsupported FourCC code:",function(p){return String.fromCharCode(255&p,p>>8&255,p>>16&255,p>>24&255)}(m)),null}let S=1,L=d[4],R=d[3];0==(3&L)&&0==(3&R)||(j.warn("Rounding up compressed texture size to nearest multiple of 4."),L=L+3&-4,R=R+3&-4);const w=L,re=R;let ve,oe;131072&d[2]&&!1!==l&&(S=Math.max(1,d[7])),1===S||(0,Ee.wt)(L)&&(0,Ee.wt)(R)||(j.warn("Ignoring mipmaps of non power of two sized compressed texture."),S=1);let Me=d[1]+4;const J=[];for(let Oe=0;Oe<S;++Oe)oe=(L+3>>2)*(R+3>>2)*_,ve=new Uint8Array(p,Me,oe),J.push(ve),Me+=oe,L=Math.max(1,L>>1),R=Math.max(1,R>>1);return{textureData:{type:"compressed",levels:J},internalFormat:E,width:w,height:re}}(d,l.hasMipmap);return l.samplingMode=m.levels.length>1?9987:9729,l.hasMipmap=m.levels.length>1,l.internalFormat=_,l.width=E,l.height=S,new b.Z(p,l,m)}(l,this.createDescriptor(l),d),this.glTexture}loadFromKTX2(l,d){return this.loadAsync(()=>function(p,l,d){return F.apply(this,arguments)}(l,this.createDescriptor(l),d).then(m=>(this.glTexture=m,m)))}loadFromBasis(l,d){return this.loadAsync(()=>function(p,l,d){return ze.apply(this,arguments)}(l,this.createDescriptor(l),d).then(m=>(this.glTexture=m,m)))}loadFromPixelData(l,d){(0,We.hu)(this.params.width>0&&this.params.height>0);const m=this.createDescriptor(l);return m.pixelFormat=1===this.params.components?6409:3===this.params.components?6407:6408,m.width=this.params.width,m.height=this.params.height,this.glTexture=new b.Z(l,m,d),this.glTexture}loadAsync(l){const d=(0,$e.yi)();this.loadingController=d;const m=l(d.signal);this.loadingPromise=m;const _=()=>{this.loadingController===d&&(this.loadingController=null),this.loadingPromise===m&&(this.loadingPromise=null)};return m.then(_,_),m}loadFromURL(l,d,m){var _=this;return this.loadAsync(function(){var E=(0,C.Z)(function*(S){const L=yield(0,ft.t)(m,{signal:S});return _.loadFromImage(l,L,d)});return function(S){return E.apply(this,arguments)}}())}loadFromImageElement(l,d,m){var _=this;return m.complete?this.loadFromImage(l,m,d):this.loadAsync(function(){var E=(0,C.Z)(function*(S){const L=yield(0,yt.f)(m,m.src,!1,S);return _.loadFromImage(l,L,d)});return function(S){return E.apply(this,arguments)}}())}loadFromVideoElement(l,d,m){return m.readyState>=2?this.loadFromImage(l,m,d):this.loadFromVideoElementAsync(l,d,m)}loadFromVideoElementAsync(l,d,m){return this.loadAsync(_=>new Promise((E,S)=>{const L=()=>{m.removeEventListener("loadeddata",R),m.removeEventListener("error",w),(0,y.pC)(re)&&re.remove()},R=()=>{m.readyState>=2&&(L(),E(this.loadFromImage(l,m,d)))},w=ve=>{L(),S(ve||new Ke.Z("Failed to load video"))};m.addEventListener("loadeddata",R),m.addEventListener("error",w);const re=(0,$e.fu)(_,()=>w((0,$e.zE)()))}))}loadFromImage(l,d,m){const _=Ge.getDataDimensions(d);this.params.width=_.width,this.params.height=_.height;const E=this.createDescriptor(l);return E.pixelFormat=3===this.params.components?6407:6408,!this.requiresPowerOfTwo(l,E)||(0,Ee.wt)(_.width)&&(0,Ee.wt)(_.height)?(E.width=_.width,E.height=_.height,this.glTexture=new b.Z(l,E,d),this.glTexture):(this.glTexture=this.makePowerOfTwoTexture(l,d,_,E,m),this.glTexture)}requiresPowerOfTwo(l,d){const m=33071,_="number"==typeof d.wrapMode?d.wrapMode===m:d.wrapMode.s===m&&d.wrapMode.t===m;return!(0,Pt.Z)(l.gl)&&(d.hasMipmap||!_)}makePowerOfTwoTexture(l,d,m,_,E){const{width:S,height:L}=m,R=(0,Ee.Sf)(S),w=(0,Ee.Sf)(L);let re;switch(_.width=R,_.height=w,this.params.powerOfTwoResizeMode){case 2:_.textureCoordinateScaleFactor=[S/R,L/w],re=new b.Z(l,_),re.updateData(0,0,0,S,L,d);break;case 1:case null:case void 0:re=this.stretchToPowerOfTwo(l,d,_,E);break;default:(0,ut.Bg)(this.params.powerOfTwoResizeMode)}return _.hasMipmap&&re.generateMipmap(),re}stretchToPowerOfTwo(l,d,m,_){const E=new b.Z(l,m),S=new Yt.Z(l,{colorTarget:0,depthStencilTarget:0},E),L=new b.Z(l,{target:3553,pixelFormat:m.pixelFormat,dataType:5121,wrapMode:33071,samplingMode:9729,flipped:!!m.flipped,maxAnisotropy:8,preMultiplyAlpha:m.preMultiplyAlpha},d),R=function(p,l=Ht,d=vt,m=-1,_=1){let E=null;return E=l===Nt?new Float32Array([m,m,0,0,_,m,1,0,m,_,0,1,_,_,1,1]):new Float32Array([m,m,_,m,m,_,_,_]),new Ot.Z(p,d,{geometry:l},{geometry:Rt.Z.createVertex(p,35044,E)})}(l);return this.drawStretchedTexture(l,_,S,R,L,E),this.requiresFrameUpdates?this.powerOfTwoStretchInfo={vao:R,sourceTexture:L,framebuffer:S}:(R.dispose(!0),L.dispose(),S.detachColorTexture(),l.bindFramebuffer(null),S.dispose()),E}drawStretchedTexture(l,d,m,_,E,S){l.bindFramebuffer(m);const L=l.getViewport();l.setViewport(0,0,S.descriptor.width,S.descriptor.height);const R=d.program;l.useProgram(R),R.setUniform4f("color",1,1,1,1),R.bindTexture(E,"tex"),l.bindVAO(_),l.setPipelineState(d.pipeline),l.drawArrays(5,0,(0,X._V)(_,"geometry")),l.bindFramebuffer(null),l.setViewport(L.x,L.y,L.width,L.height)}unload(){if((0,y.pC)(this.powerOfTwoStretchInfo)){const{framebuffer:l,vao:d,sourceTexture:m}=this.powerOfTwoStretchInfo;d.dispose(!0),m.dispose(),l.dispose(),this.glTexture=null,this.powerOfTwoStretchInfo=null}if((0,y.pC)(this.glTexture)&&(this.glTexture.dispose(),this.glTexture=null),(0,y.pC)(this.loadingController)){const l=this.loadingController;this.loadingController=null,this.loadingPromise=null,l.abort()}this.events.emit("unloaded")}}Ge.DDS_ENCODING="image/vnd-ms.dds",Ge.KTX2_ENCODING="image/ktx2",Ge.BASIS_ENCODING="image/x.basis";var Ut=v(18609),Wt=v(38238);const At=p=>class extends p{constructor(){super(...arguments),this._isDisposed=!1}dispose(){for(const _ of null!=(m=this._managedDisposables)?m:[]){var m;const E=this[_];this[_]=null,E&&"function"==typeof E.dispose&&E.dispose()}this._isDisposed=!0}get isDisposed(){return this._isDisposed}};class Dt extends(At(class{})){}class Qt extends Dt{constructor(l){super(),this._material=l.material,this._techniqueRep=l.techniqueRep,this._output=l.output}get technique(){return this._technique}getPipelineState(l,d){return this.technique.pipeline}ensureResources(l){return 2}ensureParameters(l){}}class Vt extends Qt{constructor(l){super(l),this._textureIDs=new Set,this._textureRepository=l.textureRep,this._textureId=l.textureId,this._initTransparent=!!l.initTextureTransparent,this._texture=this._acquire(this._textureId),this._textureNormal=this._acquire(l.normalTextureId),this._textureEmissive=this._acquire(l.emissiveTextureId),this._textureOcclusion=this._acquire(l.occlusionTextureId),this._textureMetallicRoughness=this._acquire(l.metallicRoughnessTextureId)}dispose(){this._textureIDs.forEach(l=>this._textureRepository.release(l)),this._textureIDs.clear()}updateTexture(l){l!==this._textureId&&(this._release(this._textureId),this._textureId=l,this._texture=this._acquire(this._textureId))}bindTextures(l){(0,y.pC)(this._texture)&&l.bindTexture(this._texture.glTexture,"tex"),(0,y.pC)(this._textureNormal)&&l.bindTexture(this._textureNormal.glTexture,"normalTexture"),(0,y.pC)(this._textureEmissive)&&l.bindTexture(this._textureEmissive.glTexture,"texEmission"),(0,y.pC)(this._textureOcclusion)&&l.bindTexture(this._textureOcclusion.glTexture,"texOcclusion"),(0,y.pC)(this._textureMetallicRoughness)&&l.bindTexture(this._textureMetallicRoughness.glTexture,"texMetallicRoughness")}bindTextureScale(l){const d=(0,y.pC)(this._texture)&&this._texture.glTexture;d&&d.descriptor.textureCoordinateScaleFactor?l.setUniform2fv("textureCoordinateScaleFactor",d.descriptor.textureCoordinateScaleFactor):l.setUniform2f("textureCoordinateScaleFactor",1,1)}_acquire(l){if(!(0,y.Wi)(l))return this._textureIDs.add(l),this._textureRepository.acquire(l,this._initTransparent)}_release(l){(0,y.Wi)(l)||(this._textureIDs.delete(l),this._textureRepository.release(l))}}var Ct=v(13773);class nr extends we{constructor(l,d){super(),this.type=3,this.supportsEdges=!1,this._visible=!0,this._renderPriority=0,this._insertOrder=0,this._vertexAttributeLocations=vt,this._params=(0,Ct.Uf)(l,d),this.validateParameterValues(this._params)}dispose(){}get params(){return this._params}update(l){return!1}setParameterValues(l){(0,Ct.LO)(this._params,l)&&(this.validateParameterValues(this._params),this.parametersChanged())}validateParameterValues(l){}get visible(){return this._visible}set visible(l){l!==this._visible&&(this._visible=l,this.parametersChanged())}isVisibleInPass(l){return!0}get renderOccluded(){return this.params.renderOccluded}get renderPriority(){return this._renderPriority}set renderPriority(l){l!==this._renderPriority&&(this._renderPriority=l,this.parametersChanged())}get insertOrder(){return this._insertOrder}set insertOrder(l){l!==this._insertOrder&&(this._insertOrder=l,this.parametersChanged())}get vertexAttributeLocations(){return this._vertexAttributeLocations}isVisible(){return this._visible}parametersChanged(){(0,y.pC)(this.materialRepository)&&this.materialRepository.materialChanged(this)}}var tr=v(42683),Qr=v(38203),Jr=v(9334),qr=v(78522),ar=v(82975),ei=(v(67474),v(75660)),ti=v(92706),zt=v(83876);new ti.x(function(){return{origin:null,direction:null}}),(0,O.c)(),(0,O.c)();const li=Re.Z.getLogger("esri.geometry.support.sphere");function vr(){return(0,ar.c)()}function Pr(p,l=vr()){return(0,ei.c)(l,p)}function pr(p){return Array.isArray(p)?p[3]:p}function Gt(p){return Array.isArray(p)?p:Mi}function lr(p,l,d){if((0,y.Wi)(l))return!1;const m=(0,T.f)(zt.WM.get(),l.origin,Gt(p)),_=(0,T.d)(l.direction,l.direction),E=2*(0,T.d)(l.direction,m),S=E*E-4*_*((0,T.d)(m,m)-p[3]*p[3]);if(S<0)return!1;const L=Math.sqrt(S);let R=(-E-L)/(2*_);const w=(-E+L)/(2*_);return(R<0||w<R&&w>0)&&(R=w),!(R<0||(d&&(0,T.b)(d,l.origin,(0,T.a)(zt.WM.get(),l.direction,R)),0))}function Sr(p,l,d){const m=zt.WM.get(),_=zt.MP.get();(0,T.c)(m,l.origin,l.direction);const E=pr(p);(0,T.c)(d,m,l.origin),(0,T.a)(d,d,1/(0,T.l)(d)*E);const S=Or(p,l.origin),L=function(p,l){const d=(0,T.d)(p,l)/((0,T.l)(p)*(0,T.l)(l));return-(0,Ee.ZF)(d)}(l.origin,d);return(0,B.i)(_),(0,B.d)(_,_,L+S,m),(0,T.m)(d,d,_),d}function Ar(p,l,d){const m=(0,T.f)(zt.WM.get(),l,Gt(p)),_=(0,T.a)(zt.WM.get(),m,p[3]/(0,T.l)(m));return(0,T.b)(d,_,Gt(p))}function Or(p,l){const d=(0,T.f)(zt.WM.get(),l,Gt(p)),m=(0,T.l)(d),_=pr(p),E=_+Math.abs(_-m);return(0,Ee.ZF)(_/E)}const gr=(0,O.c)();function wr(p,l,d,m){const _=(0,T.f)(gr,l,Gt(p));switch(d){case 0:{const E=(0,Ee.jE)(_,gr)[2];return(0,T.s)(m,-Math.sin(E),Math.cos(E),0)}case 1:{const E=(0,Ee.jE)(_,gr),S=E[1],L=E[2],R=Math.sin(S);return(0,T.s)(m,-R*Math.cos(L),-R*Math.sin(L),Math.cos(S))}case 2:return(0,T.n)(m,_);default:return}}function Dr(p,l){const d=(0,T.f)(_r,l,Gt(p));return(0,T.l)(d)-p[3]}const Mi=(0,O.c)(),_r=(0,O.c)();Object.freeze({__proto__:null,create:vr,copy:Pr,fromCenterAndRadius:function(p,l){return(0,ar.f)(p[0],p[1],p[2],l)},wrap:function(p){return p},clear:function(p){p[0]=p[1]=p[2]=p[3]=0},fromRadius:function(p){return p},getRadius:pr,getCenter:Gt,fromValues:function(p,l,d,m){return(0,ar.f)(p,l,d,m)},elevate:function(p,l,d){return p!==d&&(0,T.g)(d,p),d[3]=p[3]+l,d},setExtent:function(p,l,d){return li.error("sphere.setExtent is not yet supported"),p===d?d:Pr(p,d)},intersectRay:lr,intersectsRay:function(p,l){return lr(p,l,null)},intersectRayClosestSilhouette:function(p,l,d){if(lr(p,l,d))return d;const m=Sr(p,l,zt.WM.get());return(0,T.b)(d,l.origin,(0,T.a)(zt.WM.get(),l.direction,(0,T.i)(l.origin,m)/(0,T.l)(l.direction))),d},closestPointOnSilhouette:Sr,closestPoint:function(p,l,d){return lr(p,l,d)?d:(function(p,l,d){const m=(0,T.d)(p.direction,(0,T.f)(d,l,p.origin));(0,T.b)(d,p.origin,(0,T.a)(d,p.direction,m))}(l,Gt(p),d),Ar(p,d,d))},projectPoint:Ar,distanceToSilhouette:function(p,l){const d=(0,T.f)(zt.WM.get(),l,Gt(p)),m=(0,T.p)(d);return Math.sqrt(Math.abs(m-p[3]*p[3]))},angleToSilhouette:Or,axisAt:wr,altitudeAt:Dr,setAltitudeAt:function(p,l,d,m){const _=Dr(p,l),E=wr(p,l,2,_r),S=(0,T.a)(_r,E,d-_);return(0,T.b)(m,l,S)}});const Lr=new class{constructor(l=0){this.offset=l,this.sphere=vr(),this.tmpVertex=(0,O.c)()}applyToVertex(l,d,m){const _=this.objectTransform.transform;let E=_[0]*l+_[4]*d+_[8]*m+_[12],S=_[1]*l+_[5]*d+_[9]*m+_[13],L=_[2]*l+_[6]*d+_[10]*m+_[14];const R=this.offset/Math.sqrt(E*E+S*S+L*L);E+=E*R,S+=S*R,L+=L*R;const w=this.objectTransform.inverse;return this.tmpVertex[0]=w[0]*E+w[4]*S+w[8]*L+w[12],this.tmpVertex[1]=w[1]*E+w[5]*S+w[9]*L+w[13],this.tmpVertex[2]=w[2]*E+w[6]*S+w[10]*L+w[14],this.tmpVertex}applyToMinMax(l,d){const m=this.offset/Math.sqrt(l[0]*l[0]+l[1]*l[1]+l[2]*l[2]);l[0]+=l[0]*m,l[1]+=l[1]*m,l[2]+=l[2]*m;const _=this.offset/Math.sqrt(d[0]*d[0]+d[1]*d[1]+d[2]*d[2]);d[0]+=d[0]*_,d[1]+=d[1]*_,d[2]+=d[2]*_}applyToAabb(l){const d=this.offset/Math.sqrt(l[0]*l[0]+l[1]*l[1]+l[2]*l[2]);l[0]+=l[0]*d,l[1]+=l[1]*d,l[2]+=l[2]*d;const m=this.offset/Math.sqrt(l[3]*l[3]+l[4]*l[4]+l[5]*l[5]);return l[3]+=l[3]*m,l[4]+=l[4]*m,l[5]+=l[5]*m,l}applyToBoundingSphere(l){const d=Math.sqrt(l[0]*l[0]+l[1]*l[1]+l[2]*l[2]),m=this.offset/d;return this.sphere[0]=l[0]+l[0]*m,this.sphere[1]=l[1]+l[1]*m,this.sphere[2]=l[2]+l[2]*m,this.sphere[3]=l[3]+l[3]*this.offset/d,this.sphere}};new class{constructor(l=0){this.offset=l,this.componentLocalOriginLength=0,this.tmpVertex=(0,O.c)(),this.mbs=(0,ar.c)(),this.obb={center:(0,O.c)(),halfSize:(0,qr.c)(),quaternion:null}}set localOrigin(l){this.componentLocalOriginLength=Math.sqrt(l[0]*l[0]+l[1]*l[1]+l[2]*l[2])}applyToVertex(l,d,m){const _=l,E=d,S=m+this.componentLocalOriginLength,L=this.offset/Math.sqrt(_*_+E*E+S*S);return this.tmpVertex[0]=l+_*L,this.tmpVertex[1]=d+E*L,this.tmpVertex[2]=m+S*L,this.tmpVertex}applyToAabb(l){const d=l[0],m=l[1],_=l[2]+this.componentLocalOriginLength,E=l[3],S=l[4],L=l[5]+this.componentLocalOriginLength,R=this.offset/Math.sqrt(d*d+m*m+_*_);l[0]+=d*R,l[1]+=m*R,l[2]+=_*R;const w=this.offset/Math.sqrt(E*E+S*S+L*L);return l[3]+=E*w,l[4]+=S*w,l[5]+=L*w,l}applyToMbs(l){const d=Math.sqrt(l[0]*l[0]+l[1]*l[1]+l[2]*l[2]),m=this.offset/d;return this.mbs[0]=l[0]+l[0]*m,this.mbs[1]=l[1]+l[1]*m,this.mbs[2]=l[2]+l[2]*m,this.mbs[3]=l[3]+l[3]*this.offset/d,this.mbs}applyToObb(l){const d=l.center,m=this.offset/Math.sqrt(d[0]*d[0]+d[1]*d[1]+d[2]*d[2]);this.obb.center[0]=d[0]+d[0]*m,this.obb.center[1]=d[1]+d[1]*m,this.obb.center[2]=d[2]+d[2]*m,(0,T.q)(this.obb.halfSize,l.halfSize,l.quaternion),(0,T.b)(this.obb.halfSize,this.obb.halfSize,l.center);const _=this.offset/Math.sqrt(this.obb.halfSize[0]*this.obb.halfSize[0]+this.obb.halfSize[1]*this.obb.halfSize[1]+this.obb.halfSize[2]*this.obb.halfSize[2]);return this.obb.halfSize[0]+=this.obb.halfSize[0]*_,this.obb.halfSize[1]+=this.obb.halfSize[1]*_,this.obb.halfSize[2]+=this.obb.halfSize[2]*_,(0,T.f)(this.obb.halfSize,this.obb.halfSize,l.center),(0,Qr.c)(Fr,l.quaternion),(0,T.q)(this.obb.halfSize,this.obb.halfSize,Fr),this.obb.halfSize[0]*=this.obb.halfSize[0]<0?-1:1,this.obb.halfSize[1]*=this.obb.halfSize[1]<0?-1:1,this.obb.halfSize[2]*=this.obb.halfSize[2]<0?-1:1,this.obb.quaternion=l.quaternion,this.obb}},new class{constructor(l=0){this.offset=l,this.tmpVertex=(0,O.c)()}applyToVertex(l,d,m){const _=l+this.localOrigin[0],E=d+this.localOrigin[1],S=m+this.localOrigin[2],L=this.offset/Math.sqrt(_*_+E*E+S*S);return this.tmpVertex[0]=l+_*L,this.tmpVertex[1]=d+E*L,this.tmpVertex[2]=m+S*L,this.tmpVertex}applyToAabb(l){const d=l[0]+this.localOrigin[0],m=l[1]+this.localOrigin[1],_=l[2]+this.localOrigin[2],E=l[3]+this.localOrigin[0],S=l[4]+this.localOrigin[1],L=l[5]+this.localOrigin[2],R=this.offset/Math.sqrt(d*d+m*m+_*_);l[0]+=d*R,l[1]+=m*R,l[2]+=_*R;const w=this.offset/Math.sqrt(E*E+S*S+L*L);return l[3]+=E*w,l[4]+=S*w,l[5]+=L*w,l}};const Fr=(0,Jr.a)();function Pi(p,l,d,m){const _=d.typedBuffer,E=d.typedBufferStride,S=p.length;m*=E;for(let L=0;L<S;++L){const R=2*p[L];_[m]=l[R],_[m+1]=l[R+1],m+=E}}function Br(p,l,d,m,_){const E=d.typedBuffer,S=d.typedBufferStride,L=p.length;if(m*=S,null==_||1===_)for(let R=0;R<L;++R){const w=3*p[R];E[m]=l[w],E[m+1]=l[w+1],E[m+2]=l[w+2],m+=S}else for(let R=0;R<L;++R){const w=3*p[R];for(let re=0;re<_;++re)E[m]=l[w],E[m+1]=l[w+1],E[m+2]=l[w+2],m+=S}}function Ai(p,l,d,m,_,E=1){if(!d)return void Br(p,l,m,_,E);const S=m.typedBuffer,L=m.typedBufferStride,R=p.length,w=d[0],re=d[1],ve=d[2],oe=d[4],Me=d[5],J=d[6],Oe=d[8],Ie=d[9],Ve=d[10],mt=d[12],rt=d[13],it=d[14];if(_*=L,1===E)for(let st=0;st<R;++st){const je=3*p[st],Ne=l[je],Xe=l[je+1],he=l[je+2];S[_]=w*Ne+oe*Xe+Oe*he+mt,S[_+1]=re*Ne+Me*Xe+Ie*he+rt,S[_+2]=ve*Ne+J*Xe+Ve*he+it,_+=L}else for(let st=0;st<R;++st){const je=3*p[st],Ne=l[je],Xe=l[je+1],he=l[je+2],Ue=w*Ne+oe*Xe+Oe*he+mt,qe=re*Ne+Me*Xe+Ie*he+rt,et=ve*Ne+J*Xe+Ve*he+it;for(let ke=0;ke<E;++ke)S[_]=Ue,S[_+1]=qe,S[_+2]=et,_+=L}}function Oi(p,l,d,m,_,E=1){if(!d)return void Br(p,l,m,_,E);const L=m.typedBuffer,R=m.typedBufferStride,w=p.length,re=d[0],ve=d[1],oe=d[2],Me=d[4],J=d[5],Oe=d[6],Ie=d[8],Ve=d[9],mt=d[10],rt=!(0,B.q)(d);if(_*=R,1===E)for(let je=0;je<w;++je){const Ne=3*p[je],Xe=l[Ne],he=l[Ne+1],Ue=l[Ne+2];let qe=re*Xe+Me*he+Ie*Ue,et=ve*Xe+J*he+Ve*Ue,ke=oe*Xe+Oe*he+mt*Ue;if(rt){const lt=qe*qe+et*et+ke*ke;if(lt<.999999&&lt>1e-6){const ot=1/Math.sqrt(lt);qe*=ot,et*=ot,ke*=ot}}L[_+0]=qe,L[_+1]=et,L[_+2]=ke,_+=R}else for(let je=0;je<w;++je){const Ne=3*p[je],Xe=l[Ne],he=l[Ne+1],Ue=l[Ne+2];let qe=re*Xe+Me*he+Ie*Ue,et=ve*Xe+J*he+Ve*Ue,ke=oe*Xe+Oe*he+mt*Ue;if(rt){const lt=qe*qe+et*et+ke*ke;if(lt<.999999&&lt>1e-6){const ot=1/Math.sqrt(lt);qe*=ot,et*=ot,ke*=ot}}for(let lt=0;lt<E;++lt)L[_+0]=qe,L[_+1]=et,L[_+2]=ke,_+=R}}function wi(p,l,d,m,_,E=1){if(!d)return void function(p,l,d,m,_=1){const E=d.typedBuffer,S=d.typedBufferStride,L=p.length;if(m*=S,1===_)for(let R=0;R<L;++R){const w=4*p[R];E[m]=l[w],E[m+1]=l[w+1],E[m+2]=l[w+2],E[m+3]=l[w+3],m+=S}else for(let R=0;R<L;++R){const w=4*p[R];for(let re=0;re<_;++re)E[m]=l[w],E[m+1]=l[w+1],E[m+2]=l[w+2],E[m+3]=l[w+3],m+=S}}(p,l,m,_,E);const L=m.typedBuffer,R=m.typedBufferStride,w=p.length,re=d[0],ve=d[1],oe=d[2],Me=d[4],J=d[5],Oe=d[6],Ie=d[8],Ve=d[9],mt=d[10],rt=!(0,B.q)(d);if(_*=R,1===E)for(let je=0;je<w;++je){const Ne=4*p[je],Xe=l[Ne],he=l[Ne+1],Ue=l[Ne+2],qe=l[Ne+3];let et=re*Xe+Me*he+Ie*Ue,ke=ve*Xe+J*he+Ve*Ue,lt=oe*Xe+Oe*he+mt*Ue;if(rt){const ot=et*et+ke*ke+lt*lt;if(ot<.999999&&ot>1e-6){const ct=1/Math.sqrt(ot);et*=ct,ke*=ct,lt*=ct}}L[_+0]=et,L[_+1]=ke,L[_+2]=lt,L[_+3]=qe,_+=R}else for(let je=0;je<w;++je){const Ne=4*p[je],Xe=l[Ne],he=l[Ne+1],Ue=l[Ne+2],qe=l[Ne+3];let et=re*Xe+Me*he+Ie*Ue,ke=ve*Xe+J*he+Ve*Ue,lt=oe*Xe+Oe*he+mt*Ue;if(rt){const ot=et*et+ke*ke+lt*lt;if(ot<.999999&&ot>1e-6){const ct=1/Math.sqrt(ot);et*=ct,ke*=ct,lt*=ct}}for(let ot=0;ot<E;++ot)L[_+0]=et,L[_+1]=ke,L[_+2]=lt,L[_+3]=qe,_+=R}}function Ur(p,l,d,m,_,E=1){const S=m.typedBuffer,L=m.typedBufferStride,R=p.length;if(_*=L,1===E){if(4===d)for(let w=0;w<R;++w){const re=4*p[w];S[_]=l[re],S[_+1]=l[re+1],S[_+2]=l[re+2],S[_+3]=l[re+3],_+=L}else if(3===d)for(let w=0;w<R;++w){const re=3*p[w];S[_]=l[re],S[_+1]=l[re+1],S[_+2]=l[re+2],S[_+3]=255,_+=L}}else if(4===d)for(let w=0;w<R;++w){const re=4*p[w];for(let ve=0;ve<E;++ve)S[_]=l[re],S[_+1]=l[re+1],S[_+2]=l[re+2],S[_+3]=l[re+3],_+=L}else if(3===d)for(let w=0;w<R;++w){const re=3*p[w];for(let ve=0;ve<E;++ve)S[_]=l[re],S[_+1]=l[re+1],S[_+2]=l[re+2],S[_+3]=255,_+=L}}var Fe=v(60046),Li=v(52148),Ii=v(2970),Ri=v(92849),Fi=v(52315),Bi=v(70946),Ui=v(51277),zi=v(98845),Hi=v(73184),zr=v(20865);const Nr=(0,v(52969).c)();class Wr{constructor(l,d){this._module=l,this._loadModule=d}get(){return this._module}reload(){var l=this;return(0,C.Z)(function*(){return l._module=yield l._loadModule(),l._module})()}}function Be(p={}){return(l,d)=>{var m,_;l._parameterNames=null!=(m=l._parameterNames)?m:[],l._parameterNames.push(d);const E=l._parameterNames.length-1,L=Math.ceil((0,Ee.k3)(p.count||2)),R=null!=(_=l._parameterBits)?_:[0];let w=0;for(;R[w]+L>16;)w++,w>=R.length&&R.push(0);l._parameterBits=R;const re=R[w],ve=(1<<L)-1<<re;R[w]+=L,Object.defineProperty(l,d,{get(){return this[E]},set(oe){if(this[E]!==oe&&(this[E]=oe,this._keyDirty=!0,this._parameterBits[w]=this._parameterBits[w]&~ve|+oe<<re&ve,"number"!=typeof oe&&"boolean"!=typeof oe))throw"Configuration value for "+d+" must be boolean or number, got "+typeof oe}})}}var Ki=v(36320),$i=v(25558);class Vr extends $i.${constructor(l,d,m){super(l,d.generateSource("vertex"),d.generateSource("fragment"),m),this._textures=new Map,this._freeTextureUnits=new dt.Z({deallocator:null}),this._fragmentUniforms=(0,Ki.hZ)()?d.fragmentUniforms.entries:null}stop(){this._textures.clear(),this._freeTextureUnits.clear()}bindTexture(l,d){if((0,y.Wi)(l)||null==l.glName){const _=this._textures.get(d);return _&&(this._context.bindTexture(null,_.unit),this._freeTextureUnit(_),this._textures.delete(d)),null}let m=this._textures.get(d);return null==m?(m=this._allocTextureUnit(l),this._textures.set(d,m)):m.texture=l,this._context.useProgram(this),this.setUniform1i(d,m.unit),this._context.bindTexture(l,m.unit),m.unit}rebindTextures(){this._context.useProgram(this),this._textures.forEach((l,d)=>{this._context.bindTexture(l.texture,l.unit),this.setUniform1i(d,l.unit)}),(0,y.pC)(this._fragmentUniforms)&&this._fragmentUniforms.forEach(l=>{if(("sampler2D"===l.type||"samplerCube"===l.type)&&!this._textures.has(l.name))throw new Error(`Texture sampler ${l.name} has no bound texture`)})}_allocTextureUnit(l){return{texture:l,unit:0===this._freeTextureUnits.length?this._textures.size:this._freeTextureUnits.pop()}}_freeTextureUnit(l){this._freeTextureUnits.push(l.unit)}}const Xi={mask:255},Zi={function:{func:519,ref:2,mask:2},operation:{fail:7680,zFail:7680,zPass:0}},ki={function:{func:519,ref:2,mask:2},operation:{fail:7680,zFail:7680,zPass:7681}};var Yi=v(61292),dr=v(82705);class rr extends class{constructor(l,d,m=(()=>this.dispose())){this.release=m,d&&(this._config=d.snapshot()),this._program=this.initializeProgram(l),this._pipeline=this.initializePipeline(l)}dispose(){this._program=(0,y.O3)(this._program),this._pipeline=this._config=null}reload(l){(0,y.O3)(this._program),this._program=this.initializeProgram(l)}get program(){return this._program}get pipeline(){return this._pipeline}get key(){return this._config.key}get configuration(){return this._config}bindPass(l,d){}bindMaterial(l,d){}bindDraw(l,d,m){}bindPipelineState(l){l.setPipelineState(this.pipeline)}ensureAttributeLocations(l){this.program.assertCompatibleVertexAttributeLocations(l)}get primitiveType(){return 4}}{initializeProgram(l){const d=rr.shader.get(),m=this.configuration,_=d.build({OITEnabled:0===m.transparencyPassType,output:m.output,viewingMode:l.viewingMode,receiveShadows:m.receiveShadows,slicePlaneEnabled:m.slicePlaneEnabled,sliceHighlightDisabled:m.sliceHighlightDisabled,sliceEnabledForVertexPrograms:!1,symbolColor:m.symbolColors,vvSize:m.vvSize,vvColor:m.vvColor,vvInstancingEnabled:!0,instanced:m.instanced,instancedColor:m.instancedColor,instancedDoublePrecision:m.instancedDoublePrecision,pbrMode:m.usePBR?m.isSchematic?2:1:0,hasMetalnessAndRoughnessTexture:m.hasMetalnessAndRoughnessTexture,hasEmissionTexture:m.hasEmissionTexture,hasOcclusionTexture:m.hasOcclusionTexture,hasNormalTexture:m.hasNormalTexture,hasColorTexture:m.hasColorTexture,receiveAmbientOcclusion:m.receiveAmbientOcclusion,useCustomDTRExponentForWater:!1,normalType:m.normalsTypeDerivate?3:0,doubleSidedMode:m.doubleSidedMode,vertexTangents:m.vertexTangents,attributeTextureCoordinates:m.hasMetalnessAndRoughnessTexture||m.hasEmissionTexture||m.hasOcclusionTexture||m.hasNormalTexture||m.hasColorTexture?1:0,textureAlphaPremultiplied:m.textureAlphaPremultiplied,attributeColor:m.vertexColors,screenSizePerspectiveEnabled:m.screenSizePerspective,verticalOffsetEnabled:m.verticalOffset,offsetBackfaces:m.offsetBackfaces,doublePrecisionRequiresObfuscation:(0,zr.I)(l.rctx),alphaDiscardMode:m.alphaDiscardMode,supportsTextureAtlas:!1,multipassTerrainEnabled:m.multipassTerrainEnabled,cullAboveGround:m.cullAboveGround});return new Vr(l.rctx,_,vt)}bindPass(l,d){var m,_;!function(p,l){p.setUniformMatrix4fv("proj",l)}(this.program,d.camera.projectionMatrix);const E=this.configuration.output;(1===this.configuration.output||d.multipassTerrainEnabled||3===E)&&this.program.setUniform2fv("cameraNearFar",d.camera.nearFar),d.multipassTerrainEnabled&&(this.program.setUniform2fv("inverseViewport",d.inverseViewport),(0,Bi.p)(this.program,d)),7===E&&(this.program.setUniform1f("opacity",l.opacity),this.program.setUniform1f("layerOpacity",l.layerOpacity),this.program.setUniform4fv("externalColor",l.externalColor),this.program.setUniform1i("colorMixMode",Ct.FZ[l.colorMixMode])),0===E?(d.lighting.setUniforms(this.program,!1),this.program.setUniform3fv("ambient",l.ambient),this.program.setUniform3fv("diffuse",l.diffuse),this.program.setUniform4fv("externalColor",l.externalColor),this.program.setUniform1i("colorMixMode",Ct.FZ[l.colorMixMode]),this.program.setUniform1f("opacity",l.opacity),this.program.setUniform1f("layerOpacity",l.layerOpacity),this.configuration.usePBR&&(0,Ui.nW)(this.program,l,this.configuration.isSchematic)):4===E&&(0,Fi.wW)(this.program,d),(0,Hi.uj)(this.program,l),(0,Ri.Mo)(this.program,l,d),(0,Ct.bj)(l.screenSizePerspective,this.program,"screenSizePerspectiveAlignment"),2!==l.textureAlphaMode&&3!==l.textureAlphaMode||this.program.setUniform1f("textureAlphaCutoff",l.textureAlphaCutoff),null==(m=d.shadowMap)||m.bind(this.program),null==(_=d.ssaoHelper)||_.bind(this.program,d.camera)}bindDraw(l){const d=this.configuration.instancedDoublePrecision?(0,O.f)(l.camera.viewInverseTransposeMatrix[3],l.camera.viewInverseTransposeMatrix[7],l.camera.viewInverseTransposeMatrix[11]):l.origin;(function(p,l,d){(0,B.t)(Nr,d,l),p.setUniform3fv("localOrigin",l),p.setUniformMatrix4fv("view",Nr)})(this.program,d,l.camera.viewMatrix),this.program.rebindTextures(),(0===this.configuration.output||7===this.configuration.output||1===this.configuration.output&&this.configuration.screenSizePerspective||2===this.configuration.output&&this.configuration.screenSizePerspective||4===this.configuration.output&&this.configuration.screenSizePerspective)&&function(p,l,d){p.setUniform3f("camPos",d[3]-l[0],d[7]-l[1],d[11]-l[2])}(this.program,d,l.camera.viewInverseTransposeMatrix),2===this.configuration.output&&this.program.setUniformMatrix4fv("viewNormal",l.camera.viewInverseTransposeMatrix),this.configuration.instancedDoublePrecision&&Ii.f.bindCustomOrigin(this.program,d),(0,Li.Vv)(this.program,this.configuration,l.slicePlane,d),0===this.configuration.output&&(0,zi.vL)(this.program,l,d)}setPipeline(l,d){const m=this.configuration,_=3===l,E=2===l;return(0,dr.sm)({blending:0!==m.output&&7!==m.output||!m.transparent?null:_?tr.wu:(0,tr.$L)(l),culling:(p=m,(p.cullFace?0!==p.cullFace:!p.slicePlaneEnabled&&!p.transparent&&!p.doubleSidedMode)&&(0,dr.zp)(m.cullFace)),depthTest:{func:(0,tr.$x)(l)},depthWrite:_||E?m.writeDepth&&dr.LZ:null,colorWrite:dr.BK,stencilWrite:m.sceneHasOcludees?Xi:null,stencilTest:m.sceneHasOcludees?d?ki:Zi:null,polygonOffset:_||E?null:(0,tr.je)(m.enableOffset)});var p}initializePipeline(){return this._occludeePipelineState=this.setPipeline(this.configuration.transparencyPassType,!0),this.setPipeline(this.configuration.transparencyPassType,!1)}getPipelineState(l){return l?this._occludeePipelineState:this.pipeline}}rr.shader=new Wr(Yi.D,()=>v.e(794).then(v.bind(v,10794)));class Le extends class{constructor(){this._key="",this._keyDirty=!1,this._parameterBits=this._parameterBits.map(()=>0)}get key(){return this._keyDirty&&(this._keyDirty=!1,this._key=String.fromCharCode.apply(String,this._parameterBits)),this._key}snapshot(){const l=this._parameterNames,d={key:this.key};for(const m of l)d[m]=this[m];return d}}{constructor(){super(...arguments),this.output=0,this.alphaDiscardMode=1,this.doubleSidedMode=0,this.isSchematic=!1,this.vertexColors=!1,this.offsetBackfaces=!1,this.symbolColors=!1,this.vvSize=!1,this.vvColor=!1,this.verticalOffset=!1,this.receiveShadows=!1,this.slicePlaneEnabled=!1,this.sliceHighlightDisabled=!1,this.receiveAmbientOcclusion=!1,this.screenSizePerspective=!1,this.textureAlphaPremultiplied=!1,this.hasColorTexture=!1,this.usePBR=!1,this.hasMetalnessAndRoughnessTexture=!1,this.hasEmissionTexture=!1,this.hasOcclusionTexture=!1,this.hasNormalTexture=!1,this.instanced=!1,this.instancedColor=!1,this.instancedDoublePrecision=!1,this.vertexTangents=!1,this.normalsTypeDerivate=!1,this.writeDepth=!0,this.sceneHasOcludees=!1,this.transparent=!1,this.enableOffset=!0,this.cullFace=0,this.transparencyPassType=3,this.multipassTerrainEnabled=!1,this.cullAboveGround=!1}}(0,Fe._)([Be({count:8})],Le.prototype,"output",void 0),(0,Fe._)([Be({count:4})],Le.prototype,"alphaDiscardMode",void 0),(0,Fe._)([Be({count:3})],Le.prototype,"doubleSidedMode",void 0),(0,Fe._)([Be()],Le.prototype,"isSchematic",void 0),(0,Fe._)([Be()],Le.prototype,"vertexColors",void 0),(0,Fe._)([Be()],Le.prototype,"offsetBackfaces",void 0),(0,Fe._)([Be()],Le.prototype,"symbolColors",void 0),(0,Fe._)([Be()],Le.prototype,"vvSize",void 0),(0,Fe._)([Be()],Le.prototype,"vvColor",void 0),(0,Fe._)([Be()],Le.prototype,"verticalOffset",void 0),(0,Fe._)([Be()],Le.prototype,"receiveShadows",void 0),(0,Fe._)([Be()],Le.prototype,"slicePlaneEnabled",void 0),(0,Fe._)([Be()],Le.prototype,"sliceHighlightDisabled",void 0),(0,Fe._)([Be()],Le.prototype,"receiveAmbientOcclusion",void 0),(0,Fe._)([Be()],Le.prototype,"screenSizePerspective",void 0),(0,Fe._)([Be()],Le.prototype,"textureAlphaPremultiplied",void 0),(0,Fe._)([Be()],Le.prototype,"hasColorTexture",void 0),(0,Fe._)([Be()],Le.prototype,"usePBR",void 0),(0,Fe._)([Be()],Le.prototype,"hasMetalnessAndRoughnessTexture",void 0),(0,Fe._)([Be()],Le.prototype,"hasEmissionTexture",void 0),(0,Fe._)([Be()],Le.prototype,"hasOcclusionTexture",void 0),(0,Fe._)([Be()],Le.prototype,"hasNormalTexture",void 0),(0,Fe._)([Be()],Le.prototype,"instanced",void 0),(0,Fe._)([Be()],Le.prototype,"instancedColor",void 0),(0,Fe._)([Be()],Le.prototype,"instancedDoublePrecision",void 0),(0,Fe._)([Be()],Le.prototype,"vertexTangents",void 0),(0,Fe._)([Be()],Le.prototype,"normalsTypeDerivate",void 0),(0,Fe._)([Be()],Le.prototype,"writeDepth",void 0),(0,Fe._)([Be()],Le.prototype,"sceneHasOcludees",void 0),(0,Fe._)([Be()],Le.prototype,"transparent",void 0),(0,Fe._)([Be()],Le.prototype,"enableOffset",void 0),(0,Fe._)([Be({count:3})],Le.prototype,"cullFace",void 0),(0,Fe._)([Be({count:4})],Le.prototype,"transparencyPassType",void 0),(0,Fe._)([Be()],Le.prototype,"multipassTerrainEnabled",void 0),(0,Fe._)([Be()],Le.prototype,"cullAboveGround",void 0);var Ji=v(52119);class ur extends rr{initializeProgram(l){const d=ur.shader.get(),m=this.configuration,_=d.build({OITEnabled:0===m.transparencyPassType,output:m.output,viewingMode:l.viewingMode,receiveShadows:m.receiveShadows,slicePlaneEnabled:m.slicePlaneEnabled,sliceHighlightDisabled:m.sliceHighlightDisabled,sliceEnabledForVertexPrograms:!1,symbolColor:m.symbolColors,vvSize:m.vvSize,vvColor:m.vvColor,vvInstancingEnabled:!0,instanced:m.instanced,instancedColor:m.instancedColor,instancedDoublePrecision:m.instancedDoublePrecision,pbrMode:m.usePBR?1:0,hasMetalnessAndRoughnessTexture:!1,hasEmissionTexture:!1,hasOcclusionTexture:!1,hasNormalTexture:!1,hasColorTexture:m.hasColorTexture,receiveAmbientOcclusion:m.receiveAmbientOcclusion,useCustomDTRExponentForWater:!1,normalType:0,doubleSidedMode:2,vertexTangents:!1,attributeTextureCoordinates:m.hasColorTexture?1:0,textureAlphaPremultiplied:m.textureAlphaPremultiplied,attributeColor:m.vertexColors,screenSizePerspectiveEnabled:m.screenSizePerspective,verticalOffsetEnabled:m.verticalOffset,offsetBackfaces:m.offsetBackfaces,doublePrecisionRequiresObfuscation:(0,zr.I)(l.rctx),alphaDiscardMode:m.alphaDiscardMode,supportsTextureAtlas:!1,multipassTerrainEnabled:m.multipassTerrainEnabled,cullAboveGround:m.cullAboveGround});return new Vr(l.rctx,_,vt)}}ur.shader=new Wr(Ji.R,()=>v.e(9915).then(v.bind(v,19915)));class ir extends nr{constructor(l){super(l,eo),this.supportsEdges=!0,this.techniqueConfig=new Le,this.vertexBufferLayout=ir.getVertexBufferLayout(this.params),this.instanceBufferLayout=l.instanced?ir.getInstanceBufferLayout(this.params):null}isVisibleInPass(l){return 4!==l&&6!==l&&7!==l||this.params.castShadows}isVisible(){const l=this.params;if(!super.isVisible()||0===l.layerOpacity)return!1;const d=l.instanced,m=l.vertexColors,_=l.symbolColors,E=!!d&&d.indexOf("color")>-1,S=l.vvColorEnabled,L="replace"===l.colorMixMode,R=l.opacity>0,w=l.externalColor&&l.externalColor[3]>0;return m&&(E||S||_)?!!L||R:m?L?w:R:E||S||_?!!L||R:L?w:R}getTechniqueConfig(l,d){return this.techniqueConfig.output=l,this.techniqueConfig.hasNormalTexture=!!this.params.normalTextureId,this.techniqueConfig.hasColorTexture=!!this.params.textureId,this.techniqueConfig.vertexTangents=this.params.vertexTangents,this.techniqueConfig.instanced=!!this.params.instanced,this.techniqueConfig.instancedDoublePrecision=this.params.instancedDoublePrecision,this.techniqueConfig.vvSize=this.params.vvSizeEnabled,this.techniqueConfig.verticalOffset=null!==this.params.verticalOffset,this.techniqueConfig.screenSizePerspective=null!==this.params.screenSizePerspective,this.techniqueConfig.slicePlaneEnabled=this.params.slicePlaneEnabled,this.techniqueConfig.sliceHighlightDisabled=this.params.sliceHighlightDisabled,this.techniqueConfig.alphaDiscardMode=this.params.textureAlphaMode,this.techniqueConfig.normalsTypeDerivate="screenDerivative"===this.params.normals,this.techniqueConfig.transparent=this.params.transparent,this.techniqueConfig.writeDepth=this.params.writeDepth,this.techniqueConfig.sceneHasOcludees=this.params.sceneHasOcludees,this.techniqueConfig.cullFace=this.params.slicePlaneEnabled?0:this.params.cullFace,this.techniqueConfig.multipassTerrainEnabled=!!d&&d.multipassTerrainEnabled,this.techniqueConfig.cullAboveGround=!!d&&d.cullAboveGround,0!==l&&7!==l||(this.techniqueConfig.vertexColors=this.params.vertexColors,this.techniqueConfig.symbolColors=this.params.symbolColors,this.techniqueConfig.doubleSidedMode=this.params.treeRendering?2:this.params.doubleSided&&"normal"===this.params.doubleSidedType?1:this.params.doubleSided&&"winding-order"===this.params.doubleSidedType?2:0,this.techniqueConfig.instancedColor=!!this.params.instanced&&this.params.instanced.indexOf("color")>-1,this.techniqueConfig.receiveShadows=this.params.receiveShadows&&this.params.shadowMappingEnabled,this.techniqueConfig.receiveAmbientOcclusion=!(!d||!d.ssaoEnabled)&&this.params.receiveSSAO,this.techniqueConfig.vvColor=this.params.vvColorEnabled,this.techniqueConfig.textureAlphaPremultiplied=!!this.params.textureAlphaPremultiplied,this.techniqueConfig.usePBR=this.params.usePBR,this.techniqueConfig.hasMetalnessAndRoughnessTexture=!!this.params.metallicRoughnessTextureId,this.techniqueConfig.hasEmissionTexture=!!this.params.emissiveTextureId,this.techniqueConfig.hasOcclusionTexture=!!this.params.occlusionTextureId,this.techniqueConfig.offsetBackfaces=!(!this.params.transparent||!this.params.offsetTransparentBackfaces),this.techniqueConfig.isSchematic=this.params.usePBR&&this.params.isSchematic,this.techniqueConfig.transparencyPassType=d?d.transparencyPassType:3,this.techniqueConfig.enableOffset=!d||d.camera.relativeElevation<tr.ve),this.techniqueConfig}intersect(l,d,m,_,E,S,L){if(null!==this.params.verticalOffset){const R=_.camera;(0,T.s)(br,m[12],m[13],m[14]);let w=null;switch(_.viewingMode){case 1:w=(0,T.n)(Gr,br);break;case 2:w=(0,T.g)(Gr,oo)}let re=0;if(null!==this.params.verticalOffset){const ve=(0,T.f)(no,br,R.eye),oe=(0,T.l)(ve),Me=(0,T.a)(ve,ve,1/oe);let J=null;this.params.screenSizePerspective&&(J=(0,T.d)(w,Me)),re+=(0,Ct.Hx)(R,oe,this.params.verticalOffset,J,this.params.screenSizePerspective)}(0,T.a)(w,w,re),(0,T.t)(xr,w,_.transform.inverseRotation),E=(0,T.f)(ro,E,xr),S=(0,T.f)(io,S,xr)}var p;(0,Ct.Bw)(l,d,_,E,S,(0,y.pC)(p=_.verticalOffset)?(Lr.offset=p,Lr):null,L)}getGLMaterial(l){if(0===l.output||7===l.output||1===l.output||2===l.output||3===l.output||4===l.output)return new qi(l)}createBufferWriter(){return new to(this.vertexBufferLayout,this.instanceBufferLayout)}static getVertexBufferLayout(l){const d=l.textureId||l.normalTextureId||l.metallicRoughnessTextureId||l.emissiveTextureId||l.occlusionTextureId,m=(0,Ut.U$)().vec3f("position").vec3f("normal");return l.vertexTangents&&m.vec4f("tangent"),d&&m.vec2f("uv0"),l.vertexColors&&m.vec4u8("color"),l.symbolColors&&m.vec4u8("symbolColor"),m}static getInstanceBufferLayout(l){let d=(0,Ut.U$)();return d=l.instancedDoublePrecision?d.vec3f("modelOriginHi").vec3f("modelOriginLo").mat3f("model").mat3f("modelNormal"):d.mat4f("model").mat4f("modelNormal"),l.instanced&&l.instanced.indexOf("color")>-1&&(d=d.vec4f("instanceColor")),l.instanced&&l.instanced.indexOf("featureAttribute")>-1&&(d=d.vec4f("instanceFeatureAttribute")),d}}class qi extends Vt{constructor(l){const d=l.material;super(Lt(Lt({},l),d.params)),this.updateParameters()}updateParameters(l){const d=this._material.params;this.updateTexture(d.textureId),this._technique=this._techniqueRep.releaseAndAcquire(d.treeRendering?ur:rr,this._material.getTechniqueConfig(this._output,l),this._technique)}selectPipelines(){}_updateShadowState(l){l.shadowMappingEnabled!==this._material.params.shadowMappingEnabled&&this._material.setParameterValues({shadowMappingEnabled:l.shadowMappingEnabled})}_updateOccludeeState(l){l.hasOccludees!==this._material.params.sceneHasOcludees&&this._material.setParameterValues({sceneHasOcludees:l.hasOccludees})}ensureParameters(l){0!==this._output&&7!==this._output||(this._updateShadowState(l),this._updateOccludeeState(l)),this.updateParameters(l)}bind(l){this._technique.bindPass(this._material.params,l),this.bindTextures(this._technique.program)}beginSlot(l){return l===(this._material.params.transparent?this._material.params.writeDepth?5:8:3)||23===l}getPipelineState(l,d){return this._technique.getPipelineState(d)}}const eo=Lt({textureId:void 0,initTextureTransparent:!1,isSchematic:!1,usePBR:!1,normalTextureId:void 0,vertexTangents:!1,occlusionTextureId:void 0,emissiveTextureId:void 0,metallicRoughnessTextureId:void 0,emissiveFactor:[0,0,0],mrrFactors:[0,1,.5],ambient:[.2,.2,.2],diffuse:[.8,.8,.8],externalColor:[1,1,1,1],colorMixMode:"multiply",opacity:1,layerOpacity:1,vertexColors:!1,symbolColors:!1,doubleSided:!1,doubleSidedType:"normal",cullFace:2,instanced:void 0,instancedDoublePrecision:!1,normals:"default",receiveSSAO:!0,receiveShadows:!0,castShadows:!0,shadowMappingEnabled:!1,verticalOffset:null,screenSizePerspective:null,slicePlaneEnabled:!1,sliceHighlightDisabled:!1,offsetTransparentBackfaces:!1,vvSizeEnabled:!1,vvSizeMinSize:[1,1,1],vvSizeMaxSize:[100,100,100],vvSizeOffset:[0,0,0],vvSizeFactor:[1,1,1],vvSizeValue:[1,1,1],vvColorEnabled:!1,vvColorValues:[0,0,0,0,0,0,0,0],vvColorColors:[1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0],vvSymbolAnchor:[0,0,0],vvSymbolRotationMatrix:(0,U.c)(),transparent:!1,writeDepth:!0,textureAlphaMode:0,textureAlphaCutoff:Wt.F,textureAlphaPremultiplied:!1,sceneHasOcludees:!1},{renderOccluded:1});class to{constructor(l,d){this.vertexBufferLayout=l,this.instanceBufferLayout=d}allocate(l){return this.vertexBufferLayout.createBuffer(l)}elementCount(l){return l.indices.get("position").length}write(l,d,m,_){!function(p,l,d,m,_,E){for(const S of l.fieldNames){const L=p.vertexAttributes.get(S),R=p.indices.get(S);if(L&&R)switch(S){case"position":{(0,We.hu)(3===L.size);const w=_.getField(S,M.ct);w&&Ai(R,L.data,d,w,E);break}case"normal":{(0,We.hu)(3===L.size);const w=_.getField(S,M.ct);w&&Oi(R,L.data,m,w,E);break}case"uv0":{(0,We.hu)(2===L.size);const w=_.getField(S,M.Eu);w&&Pi(R,L.data,w,E);break}case"color":{(0,We.hu)(3===L.size||4===L.size);const w=_.getField(S,M.mc);w&&Ur(R,L.data,L.size,w,E);break}case"symbolColor":{(0,We.hu)(3===L.size||4===L.size);const w=_.getField(S,M.mc);w&&Ur(R,L.data,L.size,w,E);break}case"tangent":{(0,We.hu)(4===L.size);const w=_.getField(S,M.ek);w&&wi(R,L.data,m,w,E);break}}}}(d,this.vertexBufferLayout,l.transformation,l.invTranspTransformation,m,_)}}const ro=(0,O.c)(),io=(0,O.c)(),oo=(0,O.f)(0,0,1),Gr=(0,O.c)(),xr=(0,O.c)(),br=(0,O.c)(),no=(0,O.c)(),jt=Re.Z.getLogger("esri.views.3d.layers.graphics.objectResourceUtils");function ao(p,l){return Mr.apply(this,arguments)}function Mr(){return(Mr=(0,C.Z)(function*(p,l){const d=yield so(p,l);return{resource:d,textures:yield ho(d.textureDefinitions,l)}})).apply(this,arguments)}function so(p,l){return Tr.apply(this,arguments)}function Tr(){return(Tr=(0,C.Z)(function*(p,l){const d=(0,y.pC)(l)&&l.streamDataRequester;if(d)return lo(p,d,l);const m=yield(0,Pe.q6)((0,se.default)(p,(0,y.Wg)(l)));if(!0===m.ok)return m.value.data;(0,$e.r9)(m.error),jr(m.error)})).apply(this,arguments)}function lo(p,l,d){return yr.apply(this,arguments)}function yr(){return(yr=(0,C.Z)(function*(p,l,d){const m=yield(0,Pe.q6)(l.request(p,"json",d));if(!0===m.ok)return m.value;(0,$e.r9)(m.error),jr(m.error.details.url)})).apply(this,arguments)}function jr(p){throw new Ke.Z("",`Request for object resource failed: ${p}`)}function co(p){const l=p.params,d=l.topology;let m=!0;switch(l.vertexAttributes||(jt.warn("Geometry must specify vertex attributes"),m=!1),l.topology){case"PerAttributeArray":break;case"Indexed":case null:case void 0:{const E=l.faces;if(E){if(l.vertexAttributes)for(const S in l.vertexAttributes){const L=E[S];L&&L.values?(null!=L.valueType&&"UInt32"!==L.valueType&&(jt.warn(`Unsupported indexed geometry indices type '${L.valueType}', only UInt32 is currently supported`),m=!1),null!=L.valuesPerElement&&1!==L.valuesPerElement&&(jt.warn(`Unsupported indexed geometry values per element '${L.valuesPerElement}', only 1 is currently supported`),m=!1)):(jt.warn(`Indexed geometry does not specify face indices for '${S}' attribute`),m=!1)}}else jt.warn("Indexed geometries must specify faces"),m=!1;break}default:jt.warn(`Unsupported topology '${d}'`),m=!1}p.params.material||(jt.warn("Geometry requires material"),m=!1);const _=p.params.vertexAttributes;for(const E in _)_[E].values||(jt.warn("Geometries with externally defined attributes are not yet supported"),m=!1);return m}function uo(p,l){const d=[],m=[],_=[],E=[],S=p.resource,L=Te.G.parse(S.version||"1.0","wosr");vo.validate(L);const R=S.model.name,w=S.model.geometries,re=S.materialDefinitions,ve=p.textures;let oe=0;const Me=new Map;for(let J=0;J<w.length;J++){const Oe=w[J];if(!co(Oe))continue;const Ie=mo(Oe),Ve=Oe.params.vertexAttributes,mt=[];for(const he in Ve){const Ue=Ve[he];mt.push([he,{data:Ue.values,size:Ue.valuesPerElement,exclusive:!0}])}const rt=[];if("PerAttributeArray"!==Oe.params.topology){const he=Oe.params.faces;for(const Ue in he)rt.push([Ue,new Uint32Array(he[Ue].values)])}const it=ve&&ve[Ie.texture];if(it&&!Me.has(Ie.texture)){const{image:he,params:Ue}=it,qe=new Ge(he,Ue);E.push(qe),Me.set(Ie.texture,qe)}const st=Me.get(Ie.texture),je=st?st.id:void 0;let Ne=_[Ie.material]?_[Ie.material][Ie.texture]:null;if(!Ne){const he=re[Ie.material.substring(Ie.material.lastIndexOf("/")+1)].params;1===he.transparency&&(he.transparency=0);const Ue=it&&it.alphaChannelUsage,qe=he.transparency>0||"transparency"===Ue||"maskAndTransparency"===Ue,et=it?Kr(it.alphaChannelUsage):void 0,ke={ambient:(0,O.d)(he.diffuse),diffuse:(0,O.d)(he.diffuse),opacity:1-(he.transparency||0),transparent:qe,textureAlphaMode:et,textureAlphaCutoff:.33,textureId:je,initTextureTransparent:!0,doubleSided:!0,cullFace:0,colorMixMode:he.externalColorMixMode||"tint",textureAlphaPremultiplied:!!it&&!!it.params.preMultiplyAlpha};(0,y.pC)(l)&&l.materialParamsMixin&&Object.assign(ke,l.materialParamsMixin),Ne=new ir(ke),_[Ie.material]||(_[Ie.material]={}),_[Ie.material][Ie.texture]=Ne}m.push(Ne);const Xe=new ue(mt,rt);oe+=rt.position?rt.position.length:0,d.push(Xe)}return{name:R,stageResources:{textures:E,materials:m,geometries:d},pivotOffset:S.model.pivotOffset,boundingBox:fo(d),numberOfVertices:oe,lodThreshold:null}}function fo(p){const l=(0,x.cS)();return p.forEach(d=>{const m=d.boundingInfo;(0,y.pC)(m)&&((0,x.pp)(l,m.getBBMin()),(0,x.pp)(l,m.getBBMax()))}),l}function ho(p,l){return Er.apply(this,arguments)}function Er(){return(Er=(0,C.Z)(function*(p,l){const d=[];for(const E in p){const S=p[E],L=S.images[0].data;if(!L){jt.warn("Externally referenced texture data is not yet supported");continue}const R=S.encoding+";base64,"+L,w="/textureDefinitions/"+E,re="rgba"===S.channels?S.alphaChannelUsage||"transparency":"none",ve={noUnpackFlip:!0,wrap:{s:10497,t:10497},preMultiplyAlpha:1!==Kr(re)},oe=(0,y.pC)(l)&&l.disableTextures?Promise.resolve(null):(0,ft.t)(R,l);d.push(oe.then(Me=>({refId:w,image:Me,params:ve,alphaChannelUsage:re})))}const m=yield Promise.all(d),_={};for(const E of m)_[E.refId]=E;return _})).apply(this,arguments)}function Kr(p){switch(p){case"mask":return 2;case"maskAndTransparency":return 3;case"none":return 1;default:return 0}}function mo(p){const l=p.params;return{id:1,material:l.material,texture:l.texture,region:l.texture}}const vo=new Te.G(1,2,"wosr");var er=v(80850),po=v(47360),$r=v(89914),go=v(52055);function _o(p,l){return Cr.apply(this,arguments)}function Cr(){return(Cr=(0,C.Z)(function*(p,l){const d=Xr((0,W.pJ)(p));if("wosr"===d.fileType){const R=yield l.cache?l.cache.loadWOSR(d.url,l):ao(d.url,l),w=uo(R,l);return{lods:[w],referenceBoundingBox:w.boundingBox,isEsriSymbolResource:!1,isWosr:!0,remove:R.remove}}const m=yield l.cache?l.cache.loadGLTF(d.url,l,l.usePBR):(0,ne.z)(new Y.C(l.streamDataRequester),d.url,l,l.usePBR),_=(0,y.U2)(m.model.meta,"ESRI_proxyEllipsoid");m.meta.isEsriSymbolResource&&(0,y.pC)(_)&&-1!==m.meta.uri.indexOf("/RealisticTrees/")&&Mo(m,_);const E=m.meta.isEsriSymbolResource?{usePBR:l.usePBR,isSchematic:!1,treeRendering:m.customMeta.esriTreeRendering,mrrFactors:[0,1,.2]}:{usePBR:l.usePBR,isSchematic:!1,mrrFactors:[0,1,.5]},S=or(Lt({},l.materialParamsMixin),{treeRendering:m.customMeta.esriTreeRendering});if(null!=d.specifiedLodIndex){const R=fr(m,E,S,d.specifiedLodIndex);let w=R[0].boundingBox;return 0!==d.specifiedLodIndex&&(w=fr(m,E,S,0)[0].boundingBox),{lods:R,referenceBoundingBox:w,isEsriSymbolResource:m.meta.isEsriSymbolResource,isWosr:!1,remove:m.remove}}const L=fr(m,E,S);return{lods:L,referenceBoundingBox:L[0].boundingBox,isEsriSymbolResource:m.meta.isEsriSymbolResource,isWosr:!1,remove:m.remove}})).apply(this,arguments)}function Xr(p){const l=p.match(/(.*\.(gltf|glb))(\?lod=([0-9]+))?$/);return l?{fileType:"gltf",url:l[1],specifiedLodIndex:null!=l[4]?Number(l[4]):null}:p.match(/(.*\.(json|json\.gz))$/)?{fileType:"wosr",url:p,specifiedLodIndex:null}:{fileType:"unknown",url:p,specifiedLodIndex:null}}function fr(p,l,d,m){const _=p.model,E=(0,U.c)(),S=new Array,L=new Map,R=new Map;return _.lods.forEach((w,re)=>{if(void 0!==m&&re!==m)return;const ve={name:w.name,stageResources:{textures:new Array,materials:new Array,geometries:new Array},lodThreshold:(0,y.pC)(w.lodThreshold)?w.lodThreshold:null,pivotOffset:[0,0,0],numberOfVertices:0,boundingBox:(0,x.cS)()};S.push(ve),w.parts.forEach(oe=>{const Me=oe.material+(oe.attributes.normal?"_normal":"")+(oe.attributes.color?"_color":"")+(oe.attributes.texCoord0?"_texCoord0":"")+(oe.attributes.tangent?"_tangent":""),J=_.materials.get(oe.material),Oe=(0,y.pC)(oe.attributes.texCoord0),Ie=(0,y.pC)(oe.attributes.normal),Ve=function(p){switch(p){case"BLEND":return 0;case"MASK":return 2;case"OPAQUE":case null:case void 0:return 1}}(J.alphaMode);if(!L.has(Me)){if(Oe){if((0,y.pC)(J.textureColor)&&!R.has(J.textureColor)){const ct=_.textures.get(J.textureColor),To=or(Lt({},ct.parameters),{preMultiplyAlpha:1!==Ve});R.set(J.textureColor,new Ge(ct.data,To))}if((0,y.pC)(J.textureNormal)&&!R.has(J.textureNormal)){const ct=_.textures.get(J.textureNormal);R.set(J.textureNormal,new Ge(ct.data,ct.parameters))}if((0,y.pC)(J.textureOcclusion)&&!R.has(J.textureOcclusion)){const ct=_.textures.get(J.textureOcclusion);R.set(J.textureOcclusion,new Ge(ct.data,ct.parameters))}if((0,y.pC)(J.textureEmissive)&&!R.has(J.textureEmissive)){const ct=_.textures.get(J.textureEmissive);R.set(J.textureEmissive,new Ge(ct.data,ct.parameters))}if((0,y.pC)(J.textureMetallicRoughness)&&!R.has(J.textureMetallicRoughness)){const ct=_.textures.get(J.textureMetallicRoughness);R.set(J.textureMetallicRoughness,new Ge(ct.data,ct.parameters))}}const he=Kt(J.color[0],1/er.K),Ue=Kt(J.color[1],1/er.K),qe=Kt(J.color[2],1/er.K),et=Kt(J.emissiveFactor[0],1/er.K),ke=Kt(J.emissiveFactor[1],1/er.K),lt=Kt(J.emissiveFactor[2],1/er.K),ot=(0,y.pC)(J.textureColor)&&Oe?R.get(J.textureColor):null;L.set(Me,new ir(Lt(or(Lt({},l),{transparent:0===Ve,textureAlphaMode:Ve,textureAlphaCutoff:J.alphaCutoff,diffuse:[he,Ue,qe],ambient:[he,Ue,qe],opacity:J.opacity,doubleSided:J.doubleSided,doubleSidedType:"winding-order",cullFace:J.doubleSided?0:2,vertexColors:!!oe.attributes.color,vertexTangents:!!oe.attributes.tangent,normals:Ie?"default":"screenDerivative",castShadows:!0,receiveSSAO:!0,textureId:(0,y.pC)(ot)?ot.id:void 0,colorMixMode:J.colorMixMode,normalTextureId:(0,y.pC)(J.textureNormal)&&Oe?R.get(J.textureNormal).id:void 0,textureAlphaPremultiplied:(0,y.pC)(ot)&&!!ot.params.preMultiplyAlpha,occlusionTextureId:(0,y.pC)(J.textureOcclusion)&&Oe?R.get(J.textureOcclusion).id:void 0,emissiveTextureId:(0,y.pC)(J.textureEmissive)&&Oe?R.get(J.textureEmissive).id:void 0,metallicRoughnessTextureId:(0,y.pC)(J.textureMetallicRoughness)&&Oe?R.get(J.textureMetallicRoughness).id:void 0,emissiveFactor:[et,ke,lt],mrrFactors:[J.metallicFactor,J.roughnessFactor,l.mrrFactors[2]],isSchematic:!1}),d)))}const mt=function(p,l){switch(l){case 4:return(0,q.nh)(p);case 5:return(0,q.DA)(p);case 6:return(0,q.jX)(p)}}(oe.indices||oe.attributes.position.count,oe.primitiveType),rt=oe.attributes.position.count,it=(0,K.gS)(M.ct,rt);(0,G.t)(it,oe.attributes.position,oe.transform);const st=[["position",{data:it.typedBuffer,size:it.elementCount,exclusive:!0}]],je=[["position",mt]];if((0,y.pC)(oe.attributes.normal)){const he=(0,K.gS)(M.ct,rt);(0,I.a)(E,oe.transform),(0,G.a)(he,oe.attributes.normal,E),st.push(["normal",{data:he.typedBuffer,size:he.elementCount,exclusive:!0}]),je.push(["normal",mt])}if((0,y.pC)(oe.attributes.tangent)){const he=(0,K.gS)(M.ek,rt);(0,I.a)(E,oe.transform),(0,k.t)(he,oe.attributes.tangent,E),st.push(["tangent",{data:he.typedBuffer,size:he.elementCount,exclusive:!0}]),je.push(["tangent",mt])}if((0,y.pC)(oe.attributes.texCoord0)){const he=(0,K.gS)(M.Eu,rt);(0,po.n)(he,oe.attributes.texCoord0),st.push(["uv0",{data:he.typedBuffer,size:he.elementCount,exclusive:!0}]),je.push(["uv0",mt])}if((0,y.pC)(oe.attributes.color)){const he=(0,K.gS)(M.mc,rt);if(4===oe.attributes.color.elementCount)oe.attributes.color instanceof M.ek?(0,k.s)(he,oe.attributes.color,255):oe.attributes.color instanceof M.mc?(0,$r.c)(he,oe.attributes.color):oe.attributes.color instanceof M.v6&&(0,k.s)(he,oe.attributes.color,1/256);else{(0,$r.f)(he,255,255,255,255);const Ue=new M.ne(he.buffer,0,4);oe.attributes.color instanceof M.ct?(0,G.s)(Ue,oe.attributes.color,255):oe.attributes.color instanceof M.ne?(0,go.c)(Ue,oe.attributes.color):oe.attributes.color instanceof M.mw&&(0,G.s)(Ue,oe.attributes.color,1/256)}st.push(["color",{data:he.typedBuffer,size:he.elementCount,exclusive:!0}]),je.push(["color",mt])}const Ne=new ue(st,je);ve.stageResources.geometries.push(Ne),ve.stageResources.materials.push(L.get(Me)),Oe&&((0,y.pC)(J.textureColor)&&ve.stageResources.textures.push(R.get(J.textureColor)),(0,y.pC)(J.textureNormal)&&ve.stageResources.textures.push(R.get(J.textureNormal)),(0,y.pC)(J.textureOcclusion)&&ve.stageResources.textures.push(R.get(J.textureOcclusion)),(0,y.pC)(J.textureEmissive)&&ve.stageResources.textures.push(R.get(J.textureEmissive)),(0,y.pC)(J.textureMetallicRoughness)&&ve.stageResources.textures.push(R.get(J.textureMetallicRoughness))),ve.numberOfVertices+=rt;const Xe=Ne.boundingInfo;(0,y.pC)(Xe)&&((0,x.pp)(ve.boundingBox,Xe.getBBMin()),(0,x.pp)(ve.boundingBox,Xe.getBBMax()))})}),S}function Mo(p,l){for(let d=0;d<p.model.lods.length;++d){const m=p.model.lods[d];p.customMeta.esriTreeRendering=!0;for(const _ of m.parts){const E=_.attributes.normal;if((0,y.Wi)(E))return;const S=_.attributes.position,L=S.count,R=(0,O.c)(),w=(0,O.c)(),re=(0,O.c)(),ve=(0,K.gS)(M.mc,L),oe=(0,K.gS)(M.ct,L),Me=(0,B.b)((0,P.c)(),_.transform);for(let J=0;J<L;J++){S.getVec(J,w),E.getVec(J,R),(0,T.m)(w,w,_.transform),(0,T.f)(re,w,l.center),(0,T.E)(re,re,l.radius);const Oe=re[2],Ie=(0,T.l)(re),Ve=Math.min(.45+.55*Ie*Ie,1);(0,T.E)(re,re,l.radius),(0,T.m)(re,re,Me),(0,T.n)(re,re),d+1!==p.model.lods.length&&p.model.lods.length>1&&(0,T.e)(re,re,R,Oe>-1?.2:Math.min(-4*Oe-3.8,1)),oe.setVec(J,re),ve.set(J,0,255*Ve),ve.set(J,1,255*Ve),ve.set(J,2,255*Ve),ve.set(J,3,255)}_.attributes.normal=oe,_.attributes.color=ve}}}},32001:(me,$,v)=>{v.d($,{q:()=>W});var C=v(97561);function W(y,I){0===I.output&&I.receiveShadows?(y.varyings.add("linearDepth","float"),y.vertex.code.add(C.H`void forwardLinearDepth() { linearDepth = gl_Position.w; }`)):1===I.output||3===I.output?(y.varyings.add("linearDepth","float"),y.vertex.uniforms.add("cameraNearFar","vec2"),y.vertex.code.add(C.H`void forwardLinearDepth() {
linearDepth = (-position_view().z - cameraNearFar[0]) / (cameraNearFar[1] - cameraNearFar[0]);
}`)):y.vertex.code.add(C.H`void forwardLinearDepth() {}`)}},34270:(me,$,v)=>{v.d($,{w:()=>W});var C=v(97561);function W(y){y.vertex.code.add(C.H`vec4 offsetBackfacingClipPosition(vec4 posClip, vec3 posWorld, vec3 normalWorld, vec3 camPosWorld) {
vec3 camToVert = posWorld - camPosWorld;
bool isBackface = dot(camToVert, normalWorld) > 0.0;
if (isBackface) {
posClip.z += 0.0000003 * posClip.w;
}
return posClip;
}`)}},52148:(me,$,v)=>{v.d($,{p2:()=>U,Vv:()=>P});var C=v(60305),W=v(6618),y=v(10127),I=v(97561);function U(O,x){if(x.slicePlaneEnabled){O.extensions.add("GL_OES_standard_derivatives"),x.sliceEnabledForVertexPrograms&&(O.vertex.uniforms.add("slicePlaneOrigin","vec3"),O.vertex.uniforms.add("slicePlaneBasis1","vec3"),O.vertex.uniforms.add("slicePlaneBasis2","vec3")),O.fragment.uniforms.add("slicePlaneOrigin","vec3"),O.fragment.uniforms.add("slicePlaneBasis1","vec3"),O.fragment.uniforms.add("slicePlaneBasis2","vec3");const M=I.H`struct SliceFactors {
float front;
float side0;
float side1;
float side2;
float side3;
};
SliceFactors calculateSliceFactors(vec3 pos) {
vec3 rel = pos - slicePlaneOrigin;
vec3 slicePlaneNormal = -cross(slicePlaneBasis1, slicePlaneBasis2);
float slicePlaneW = -dot(slicePlaneNormal, slicePlaneOrigin);
float basis1Len2 = dot(slicePlaneBasis1, slicePlaneBasis1);
float basis2Len2 = dot(slicePlaneBasis2, slicePlaneBasis2);
float basis1Dot = dot(slicePlaneBasis1, rel);
float basis2Dot = dot(slicePlaneBasis2, rel);
return SliceFactors(
dot(slicePlaneNormal, pos) + slicePlaneW,
-basis1Dot - basis1Len2,
basis1Dot - basis1Len2,
-basis2Dot - basis2Len2,
basis2Dot - basis2Len2
);
}
bool sliceByFactors(SliceFactors factors) {
return factors.front < 0.0
&& factors.side0 < 0.0
&& factors.side1 < 0.0
&& factors.side2 < 0.0
&& factors.side3 < 0.0;
}
bool sliceEnabled() {
return dot(slicePlaneBasis1, slicePlaneBasis1) != 0.0;
}
bool sliceByPlane(vec3 pos) {
return sliceEnabled() && sliceByFactors(calculateSliceFactors(pos));
}
#define rejectBySlice(_pos_) sliceByPlane(_pos_)
#define discardBySlice(_pos_) { if (sliceByPlane(_pos_)) discard; }`,G=I.H`vec4 applySliceHighlight(vec4 color, vec3 pos) {
SliceFactors factors = calculateSliceFactors(pos);
if (sliceByFactors(factors)) {
return color;
}
const float HIGHLIGHT_WIDTH = 1.0;
const vec4 HIGHLIGHT_COLOR = vec4(0.0, 0.0, 0.0, 0.3);
factors.front /= (2.0 * HIGHLIGHT_WIDTH) * fwidth(factors.front);
factors.side0 /= (2.0 * HIGHLIGHT_WIDTH) * fwidth(factors.side0);
factors.side1 /= (2.0 * HIGHLIGHT_WIDTH) * fwidth(factors.side1);
factors.side2 /= (2.0 * HIGHLIGHT_WIDTH) * fwidth(factors.side2);
factors.side3 /= (2.0 * HIGHLIGHT_WIDTH) * fwidth(factors.side3);
float highlightFactor = (1.0 - step(0.5, factors.front))
* (1.0 - step(0.5, factors.side0))
* (1.0 - step(0.5, factors.side1))
* (1.0 - step(0.5, factors.side2))
* (1.0 - step(0.5, factors.side3));
return mix(color, vec4(HIGHLIGHT_COLOR.rgb, color.a), highlightFactor * HIGHLIGHT_COLOR.a);
}`,k=x.sliceHighlightDisabled?I.H`#define highlightSlice(_color_, _pos_) (_color_)`:I.H`
        ${G}
        #define highlightSlice(_color_, _pos_) (sliceEnabled() ? applySliceHighlight(_color_, _pos_) : (_color_))
      `;x.sliceEnabledForVertexPrograms&&O.vertex.code.add(M),O.fragment.code.add(M),O.fragment.code.add(k)}else{const M=I.H`#define rejectBySlice(_pos_) false
#define discardBySlice(_pos_) {}
#define highlightSlice(_color_, _pos_) (_color_)`;x.sliceEnabledForVertexPrograms&&O.vertex.code.add(M),O.fragment.code.add(M)}}function P(O,x,M,G){x.slicePlaneEnabled&&((0,C.pC)(M)?(G?((0,W.f)(T,M.origin,G),O.setUniform3fv("slicePlaneOrigin",T)):O.setUniform3fv("slicePlaneOrigin",M.origin),O.setUniform3fv("slicePlaneBasis1",M.basis1),O.setUniform3fv("slicePlaneBasis2",M.basis2)):(O.setUniform3fv("slicePlaneBasis1",y.Z),O.setUniform3fv("slicePlaneBasis2",y.Z),O.setUniform3fv("slicePlaneOrigin",y.Z)))}const T=(0,y.c)()},62111:(me,$,v)=>{v.d($,{w:()=>W});var C=v(97561);function W(y,I){y.vertex.code.add(I.linearDepth?C.H`vec4 transformPositionWithDepth(mat4 proj, mat4 view, vec3 pos, vec2 nearFar, out float depth) {
vec4 eye = view * vec4(pos, 1.0);
depth = (-eye.z - nearFar[0]) / (nearFar[1] - nearFar[0]) ;
return proj * eye;
}`:C.H`vec4 transformPosition(mat4 proj, mat4 view, vec3 pos) {
return proj * (view * vec4(pos, 1.0));
}`)}},2970:(me,$,v)=>{v.d($,{f:()=>U});var T,C=v(10127),W=v(20865),y=v(97561),I=v(28258);function U(T,O){O.instanced&&O.instancedDoublePrecision&&(T.attributes.add("modelOriginHi","vec3"),T.attributes.add("modelOriginLo","vec3"),T.attributes.add("model","mat3"),T.attributes.add("modelNormal","mat3")),O.instancedDoublePrecision&&(T.vertex.include(W.$,O),T.vertex.uniforms.add("viewOriginHi","vec3"),T.vertex.uniforms.add("viewOriginLo","vec3"));const x=[y.H`
    vec3 calculateVPos() {
      ${O.instancedDoublePrecision?"return model * localPosition().xyz;":"return localPosition().xyz;"}
    }
    `,y.H`
    vec3 subtractOrigin(vec3 _pos) {
      ${O.instancedDoublePrecision?y.H`
          vec3 originDelta = dpAdd(viewOriginHi, viewOriginLo, -modelOriginHi, -modelOriginLo);
          return _pos - originDelta;`:"return vpos;"}
    }
    `,y.H`
    vec3 dpNormal(vec4 _normal) {
      ${O.instancedDoublePrecision?"return normalize(modelNormal * _normal.xyz);":"return normalize(_normal.xyz);"}
    }
    `,y.H`
    vec3 dpNormalView(vec4 _normal) {
      ${O.instancedDoublePrecision?"return normalize((viewNormal * vec4(modelNormal * _normal.xyz, 1.0)).xyz);":"return normalize((viewNormal * _normal).xyz);"}
    }
    `,O.vertexTangents?y.H`
    vec4 dpTransformVertexTangent(vec4 _tangent) {
      ${O.instancedDoublePrecision?"return vec4(modelNormal * _tangent.xyz, _tangent.w);":"return _tangent;"}

    }
    `:y.H``];T.vertex.code.add(x[0]),T.vertex.code.add(x[1]),T.vertex.code.add(x[2]),2===O.output&&T.vertex.code.add(x[3]),T.vertex.code.add(x[4])}(T=U||(U={})).Uniforms=class{},T.bindCustomOrigin=function(M,G){(0,I.po)(G,B,P,3),M.setUniform3fv("viewOriginHi",B),M.setUniform3fv("viewOriginLo",P)};const B=(0,C.c)(),P=(0,C.c)()},54237:(me,$,v)=>{v.d($,{O:()=>y});var C=v(97561);function W(I){const U=C.H`vec3 decodeNormal(vec2 f) {
float z = 1.0 - abs(f.x) - abs(f.y);
return vec3(f + sign(f) * min(z, 0.0), z);
}`;I.fragment.code.add(U),I.vertex.code.add(U)}function y(I,U){0===U.normalType&&(I.attributes.add("normal","vec3"),I.vertex.code.add(C.H`vec3 normalModel() {
return normal;
}`)),1===U.normalType&&(I.include(W),I.attributes.add("normalCompressed","vec2"),I.vertex.code.add(C.H`vec3 normalModel() {
return decodeNormal(normalCompressed);
}`)),3===U.normalType&&(I.extensions.add("GL_OES_standard_derivatives"),I.fragment.code.add(C.H`vec3 screenDerivativeNormal(vec3 positionView) {
return normalize(cross(dFdx(positionView), dFdy(positionView)));
}`))}},91859:(me,$,v)=>{v.d($,{f:()=>W});var C=v(97561);function W(y){y.attributes.add("position","vec3"),y.vertex.code.add(C.H`vec3 positionModel() { return position; }`)}},37928:(me,$,v)=>{v.d($,{R:()=>y});var C=v(97561);function W(I){I.vertex.code.add(C.H`
    vec4 decodeSymbolColor(vec4 symbolColor, out int colorMixMode) {
      float symbolAlpha = 0.0;

      const float maxTint = 85.0;
      const float maxReplace = 170.0;
      const float scaleAlpha = 3.0;

      if (symbolColor.a > maxReplace) {
        colorMixMode = ${C.H.int(1)};
        symbolAlpha = scaleAlpha * (symbolColor.a - maxReplace);
      } else if (symbolColor.a > maxTint) {
        colorMixMode = ${C.H.int(3)};
        symbolAlpha = scaleAlpha * (symbolColor.a - maxTint);
      } else if (symbolColor.a > 0.0) {
        colorMixMode = ${C.H.int(4)};
        symbolAlpha = scaleAlpha * symbolColor.a;
      } else {
        colorMixMode = ${C.H.int(1)};
        symbolAlpha = 0.0;
      }

      return vec4(symbolColor.r, symbolColor.g, symbolColor.b, symbolAlpha);
    }
  `)}function y(I,U){U.symbolColor?(I.include(W),I.attributes.add("symbolColor","vec4"),I.varyings.add("colorMixMode","mediump float")):I.fragment.uniforms.add("colorMixMode","int"),I.vertex.code.add(U.symbolColor?C.H`int symbolColorMixMode;
vec4 getSymbolColor() {
return decodeSymbolColor(symbolColor, symbolColorMixMode) * 0.003921568627451;
}
void forwardColorMixMode() {
colorMixMode = float(symbolColorMixMode) + 0.5;
}`:C.H`vec4 getSymbolColor() { return vec4(1.0); }
void forwardColorMixMode() {}`)}},19924:(me,$,v)=>{v.d($,{D:()=>W});var C=v(97561);function W(y,I){1===I.attributeTextureCoordinates&&(y.attributes.add("uv0","vec2"),y.varyings.add("vuv0","vec2"),y.vertex.code.add(C.H`void forwardTextureCoordinates() {
vuv0 = uv0;
}`)),2===I.attributeTextureCoordinates&&(y.attributes.add("uv0","vec2"),y.varyings.add("vuv0","vec2"),y.attributes.add("uvRegion","vec4"),y.varyings.add("vuvRegion","vec4"),y.vertex.code.add(C.H`void forwardTextureCoordinates() {
vuv0 = uv0;
vuvRegion = uvRegion;
}`)),0===I.attributeTextureCoordinates&&y.vertex.code.add(C.H`void forwardTextureCoordinates() {}`)}},21273:(me,$,v)=>{v.d($,{c:()=>W});var C=v(97561);function W(y,I){I.attributeColor?(y.attributes.add("color","vec4"),y.varyings.add("vColor","vec4"),y.vertex.code.add(C.H`void forwardVertexColor() { vColor = color; }`),y.vertex.code.add(C.H`void forwardNormalizedVertexColor() { vColor = color * 0.003921568627451; }`)):y.vertex.code.add(C.H`void forwardVertexColor() {}
void forwardNormalizedVertexColor() {}`)}},77461:(me,$,v)=>{v.d($,{B:()=>O});var x,C=v(54237),W=v(25461),y=v(4003),I=v(10127),U=v(91859),B=v(20865),P=v(97561);function T(x,M){x.include(U.f),x.vertex.include(B.$,M),x.varyings.add("vPositionWorldCameraRelative","vec3"),x.varyings.add("vPosition_view","vec3"),x.vertex.uniforms.add("uTransform_WorldFromModel_RS","mat3"),x.vertex.uniforms.add("uTransform_WorldFromModel_TH","vec3"),x.vertex.uniforms.add("uTransform_WorldFromModel_TL","vec3"),x.vertex.uniforms.add("uTransform_WorldFromView_TH","vec3"),x.vertex.uniforms.add("uTransform_WorldFromView_TL","vec3"),x.vertex.uniforms.add("uTransform_ViewFromCameraRelative_RS","mat3"),x.vertex.uniforms.add("uTransform_ProjFromView","mat4"),x.vertex.code.add(P.H`vec3 positionWorldCameraRelative() {
vec3 rotatedModelPosition = uTransform_WorldFromModel_RS * positionModel();
vec3 transform_CameraRelativeFromModel = dpAdd(
uTransform_WorldFromModel_TL,
uTransform_WorldFromModel_TH,
-uTransform_WorldFromView_TL,
-uTransform_WorldFromView_TH
);
return transform_CameraRelativeFromModel + rotatedModelPosition;
}
vec3 position_view() {
return uTransform_ViewFromCameraRelative_RS * positionWorldCameraRelative();
}
void forwardPosition() {
vPositionWorldCameraRelative = positionWorldCameraRelative();
vPosition_view = position_view();
gl_Position = uTransform_ProjFromView * vec4(vPosition_view, 1.0);
}
vec3 positionWorld() {
return uTransform_WorldFromView_TL + vPositionWorldCameraRelative;
}`),x.fragment.uniforms.add("uTransform_WorldFromView_TL","vec3"),x.fragment.code.add(P.H`vec3 positionWorld() {
return uTransform_WorldFromView_TL + vPositionWorldCameraRelative;
}`)}function O(x,M){0===M.normalType||1===M.normalType?(x.include(C.O,M),x.varyings.add("vNormalWorld","vec3"),x.varyings.add("vNormalView","vec3"),x.vertex.uniforms.add("uTransformNormal_GlobalFromModel","mat3"),x.vertex.uniforms.add("uTransformNormal_ViewFromGlobal","mat3"),x.vertex.code.add(P.H`void forwardNormal() {
vNormalWorld = uTransformNormal_GlobalFromModel * normalModel();
vNormalView = uTransformNormal_ViewFromGlobal * vNormalWorld;
}`)):2===M.normalType?(x.include(T,M),x.varyings.add("vNormalWorld","vec3"),x.vertex.code.add(P.H`
    void forwardNormal() {
      vNormalWorld = ${1===M.viewingMode?P.H`normalize(vPositionWorldCameraRelative);`:P.H`vec3(0.0, 0.0, 1.0);`}
    }
    `)):x.vertex.code.add(P.H`void forwardNormal() {}`)}(x=T||(T={})).ModelTransform=class{constructor(){this.worldFromModel_RS=(0,W.c)(),this.worldFromModel_TH=(0,I.c)(),this.worldFromModel_TL=(0,I.c)()}},x.ViewProjectionTransform=class{constructor(){this.worldFromView_TH=(0,I.c)(),this.worldFromView_TL=(0,I.c)(),this.viewFromCameraRelative_RS=(0,W.c)(),this.projFromView=(0,y.c)()}},x.bindModelTransform=function(Y,ne){Y.setUniformMatrix3fv("uTransform_WorldFromModel_RS",ne.worldFromModel_RS),Y.setUniform3fv("uTransform_WorldFromModel_TH",ne.worldFromModel_TH),Y.setUniform3fv("uTransform_WorldFromModel_TL",ne.worldFromModel_TL)},x.bindViewProjTransform=function(Y,ne){Y.setUniform3fv("uTransform_WorldFromView_TH",ne.worldFromView_TH),Y.setUniform3fv("uTransform_WorldFromView_TL",ne.worldFromView_TL),Y.setUniformMatrix4fv("uTransform_ProjFromView",ne.projFromView),Y.setUniformMatrix3fv("uTransform_ViewFromCameraRelative_RS",ne.viewFromCameraRelative_RS)},(O||(O={})).bindUniforms=function(G,k){G.setUniformMatrix4fv("viewNormal",k)}},94129:(me,$,v)=>{v.d($,{i:()=>I});var C=v(19924),W=v(97561);function y(U){U.extensions.add("GL_EXT_shader_texture_lod"),U.extensions.add("GL_OES_standard_derivatives"),U.fragment.code.add(W.H`#ifndef GL_EXT_shader_texture_lod
float calcMipMapLevel(const vec2 ddx, const vec2 ddy) {
float deltaMaxSqr = max(dot(ddx, ddx), dot(ddy, ddy));
return max(0.0, 0.5 * log2(deltaMaxSqr));
}
#endif
vec4 textureAtlasLookup(sampler2D texture, vec2 textureSize, vec2 textureCoordinates, vec4 atlasRegion) {
vec2 atlasScale = atlasRegion.zw - atlasRegion.xy;
vec2 uvAtlas = fract(textureCoordinates) * atlasScale + atlasRegion.xy;
float maxdUV = 0.125;
vec2 dUVdx = clamp(dFdx(textureCoordinates), -maxdUV, maxdUV) * atlasScale;
vec2 dUVdy = clamp(dFdy(textureCoordinates), -maxdUV, maxdUV) * atlasScale;
#ifdef GL_EXT_shader_texture_lod
return texture2DGradEXT(texture, uvAtlas, dUVdx, dUVdy);
#else
vec2 dUVdxAuto = dFdx(uvAtlas);
vec2 dUVdyAuto = dFdy(uvAtlas);
float mipMapLevel = calcMipMapLevel(dUVdx * textureSize, dUVdy * textureSize);
float autoMipMapLevel = calcMipMapLevel(dUVdxAuto * textureSize, dUVdyAuto * textureSize);
return texture2D(texture, uvAtlas, mipMapLevel - autoMipMapLevel);
#endif
}`)}function I(U,B){U.include(C.D,B),U.fragment.code.add(W.H`
  struct TextureLookupParameter {
    vec2 uv;
    ${B.supportsTextureAtlas?"vec2 size;":""}
  } vtc;
  `),1===B.attributeTextureCoordinates&&U.fragment.code.add(W.H`vec4 textureLookup(sampler2D tex, TextureLookupParameter params) {
return texture2D(tex, params.uv);
}`),2===B.attributeTextureCoordinates&&(U.include(y),U.fragment.code.add(W.H`vec4 textureLookup(sampler2D tex, TextureLookupParameter params) {
return textureAtlasLookup(tex, params.size, params.uv, vuvRegion);
}`))}},92849:(me,$,v)=>{v.d($,{LC:()=>U,Mo:()=>B});var C=v(97561);function y(O){O.vertex.code.add(C.H`float screenSizePerspectiveMinSize(float size, vec4 factor) {
float nonZeroSize = 1.0 - step(size, 0.0);
return (
factor.z * (
1.0 +
nonZeroSize *
2.0 * factor.w / (
size + (1.0 - nonZeroSize)
)
)
);
}`),O.vertex.code.add(C.H`float screenSizePerspectiveViewAngleDependentFactor(float absCosAngle) {
return absCosAngle * absCosAngle * absCosAngle;
}`),O.vertex.code.add(C.H`vec4 screenSizePerspectiveScaleFactor(float absCosAngle, float distanceToCamera, vec4 params) {
return vec4(
min(params.x / (distanceToCamera - params.y), 1.0),
screenSizePerspectiveViewAngleDependentFactor(absCosAngle),
params.z,
params.w
);
}`),O.vertex.code.add(C.H`float applyScreenSizePerspectiveScaleFactorFloat(float size, vec4 factor) {
return max(mix(size * factor.x, size, factor.y), screenSizePerspectiveMinSize(size, factor));
}`),O.vertex.code.add(C.H`float screenSizePerspectiveScaleFloat(float size, float absCosAngle, float distanceToCamera, vec4 params) {
return applyScreenSizePerspectiveScaleFactorFloat(
size,
screenSizePerspectiveScaleFactor(absCosAngle, distanceToCamera, params)
);
}`),O.vertex.code.add(C.H`vec2 applyScreenSizePerspectiveScaleFactorVec2(vec2 size, vec4 factor) {
return mix(size * clamp(factor.x, screenSizePerspectiveMinSize(size.y, factor) / size.y, 1.0), size, factor.y);
}`),O.vertex.code.add(C.H`vec2 screenSizePerspectiveScaleVec2(vec2 size, float absCosAngle, float distanceToCamera, vec4 params) {
return applyScreenSizePerspectiveScaleFactorVec2(size, screenSizePerspectiveScaleFactor(absCosAngle, distanceToCamera, params));
}`)}function U(O,x){const M=O.vertex.code;x.verticalOffsetEnabled?(O.vertex.uniforms.add("verticalOffset","vec4"),x.screenSizePerspectiveEnabled&&(O.include(y),O.vertex.uniforms.add("screenSizePerspectiveAlignment","vec4")),M.add(C.H`
    vec3 calculateVerticalOffset(vec3 worldPos, vec3 localOrigin) {
      float viewDistance = length((view * vec4(worldPos, 1.0)).xyz);
      ${1===x.viewingMode?C.H`vec3 worldNormal = normalize(worldPos + localOrigin);`:C.H`vec3 worldNormal = vec3(0.0, 0.0, 1.0);`}
      ${x.screenSizePerspectiveEnabled?C.H`
          float cosAngle = dot(worldNormal, normalize(worldPos - camPos));
          float verticalOffsetScreenHeight = screenSizePerspectiveScaleFloat(verticalOffset.x, abs(cosAngle), viewDistance, screenSizePerspectiveAlignment);`:C.H`
          float verticalOffsetScreenHeight = verticalOffset.x;`}
      // Screen sized offset in world space, used for example for line callouts
      float worldOffset = clamp(verticalOffsetScreenHeight * verticalOffset.y * viewDistance, verticalOffset.z, verticalOffset.w);
      return worldNormal * worldOffset;
    }

    vec3 addVerticalOffset(vec3 worldPos, vec3 localOrigin) {
      return worldPos + calculateVerticalOffset(worldPos, localOrigin);
    }
    `)):M.add(C.H`vec3 addVerticalOffset(vec3 worldPos, vec3 localOrigin) { return worldPos; }`)}function B(O,x,M){if(!x.verticalOffset)return;const G=function(O,x,M,G=T){return G.screenLength=O.screenLength,G.perDistance=Math.tan(.5*x)/(.5*M),G.minWorldLength=O.minWorldLength,G.maxWorldLength=O.maxWorldLength,G}(x.verticalOffset,M.camera.fovY,M.camera.fullViewport[3]);O.setUniform4f("verticalOffset",G.screenLength*(M.camera.pixelRatio||1),G.perDistance,G.minWorldLength,G.maxWorldLength)}v(13773);const T={screenLength:0,perDistance:0,minWorldLength:0,maxWorldLength:0}},75798:(me,$,v)=>{v.d($,{s:()=>G});var C=v(52148),W=v(62111),y=v(54237),I=v(19924),U=v(77461),B=v(5190),P=v(97561);function T(k,K){k.fragment.include(B.n),3===K.output?(k.extensions.add("GL_OES_standard_derivatives"),k.fragment.code.add(P.H`float _calculateFragDepth(const in float depth) {
const float SLOPE_SCALE = 2.0;
const float BIAS = 2.0 * .000015259;
float m = max(abs(dFdx(depth)), abs(dFdy(depth)));
float result = depth + SLOPE_SCALE * m + BIAS;
return clamp(result, .0, .999999);
}
void outputDepth(float _linearDepth) {
gl_FragColor = float2rgba(_calculateFragDepth(_linearDepth));
}`)):1===K.output&&k.fragment.code.add(P.H`void outputDepth(float _linearDepth) {
gl_FragColor = float2rgba(_linearDepth);
}`)}var O=v(52315),x=v(73184),M=v(38238);function G(k,K){const Y=k.vertex.code,ne=k.fragment.code;1!==K.output&&3!==K.output||(k.include(W.w,{linearDepth:!0}),k.include(I.D,K),k.include(x.kl,K),k.include(T,K),k.include(C.p2,K),k.vertex.uniforms.add("cameraNearFar","vec2"),k.varyings.add("depth","float"),K.hasColorTexture&&k.fragment.uniforms.add("tex","sampler2D"),Y.add(P.H`void main(void) {
vpos = calculateVPos();
vpos = subtractOrigin(vpos);
vpos = addVerticalOffset(vpos, localOrigin);
gl_Position = transformPositionWithDepth(proj, view, vpos, cameraNearFar, depth);
forwardTextureCoordinates();
}`),k.include(M.sj,K),ne.add(P.H`
      void main(void) {
        discardBySlice(vpos);
        ${K.hasColorTexture?P.H`
        vec4 texColor = texture2D(tex, vuv0);
        discardOrAdjustAlpha(texColor);`:""}
        outputDepth(depth);
      }
    `)),2===K.output&&(k.include(W.w,{linearDepth:!1}),k.include(y.O,K),k.include(U.B,K),k.include(I.D,K),k.include(x.kl,K),K.hasColorTexture&&k.fragment.uniforms.add("tex","sampler2D"),k.vertex.uniforms.add("viewNormal","mat4"),k.varyings.add("vPositionView","vec3"),Y.add(P.H`
      void main(void) {
        vpos = calculateVPos();
        vpos = subtractOrigin(vpos);
        ${0===K.normalType?P.H`
        vNormalWorld = dpNormalView(vvLocalNormal(normalModel()));`:""}
        vpos = addVerticalOffset(vpos, localOrigin);
        gl_Position = transformPosition(proj, view, vpos);
        forwardTextureCoordinates();
      }
    `),k.include(C.p2,K),k.include(M.sj,K),ne.add(P.H`
      void main() {
        discardBySlice(vpos);
        ${K.hasColorTexture?P.H`
        vec4 texColor = texture2D(tex, vuv0);
        discardOrAdjustAlpha(texColor);`:""}

        ${3===K.normalType?P.H`
            vec3 normal = screenDerivativeNormal(vPositionView);`:P.H`
            vec3 normal = normalize(vNormalWorld);
            if (gl_FrontFacing == false) normal = -normal;`}
        gl_FragColor = vec4(vec3(0.5) + 0.5 * normal, 1.0);
      }
    `)),4===K.output&&(k.include(W.w,{linearDepth:!1}),k.include(I.D,K),k.include(x.kl,K),K.hasColorTexture&&k.fragment.uniforms.add("tex","sampler2D"),Y.add(P.H`void main(void) {
vpos = calculateVPos();
vpos = subtractOrigin(vpos);
vpos = addVerticalOffset(vpos, localOrigin);
gl_Position = transformPosition(proj, view, vpos);
forwardTextureCoordinates();
}`),k.include(C.p2,K),k.include(M.sj,K),k.include(O.bA),ne.add(P.H`
      void main() {
        discardBySlice(vpos);
        ${K.hasColorTexture?P.H`
        vec4 texColor = texture2D(tex, vuv0);
        discardOrAdjustAlpha(texColor);`:""}
        outputHighlight();
      }
    `))}},52315:(me,$,v)=>{v.d($,{bA:()=>U,wW:()=>B});var C=v(82975),W=v(97561);const y=(0,C.f)(1,1,0,1),I=(0,C.f)(1,0,1,1);function U(P){P.fragment.uniforms.add("depthTex","sampler2D"),P.fragment.uniforms.add("highlightViewportPixelSz","vec4"),P.fragment.constants.add("occludedHighlightFlag","vec4",y).add("unoccludedHighlightFlag","vec4",I),P.fragment.code.add(W.H`void outputHighlight() {
vec4 fragCoord = gl_FragCoord;
float sceneDepth = texture2D(depthTex, (fragCoord.xy - highlightViewportPixelSz.xy) * highlightViewportPixelSz.zw).r;
if (fragCoord.z > sceneDepth + 5e-7) {
gl_FragColor = occludedHighlightFlag;
}
else {
gl_FragColor = unoccludedHighlightFlag;
}
}`)}function B(P,T){P.bindTexture(T.highlightDepthTexture,"depthTex"),P.setUniform4f("highlightViewportPixelSz",0,0,T.inverseViewport[0],T.inverseViewport[1])}},25583:(me,$,v)=>{v.d($,{S:()=>y});var C=v(5190),W=v(97561);function y(I){I.include(C.n),I.code.add(W.H`float linearDepthFromFloat(float depth, vec2 nearFar) {
return -(depth * (nearFar[1] - nearFar[0]) + nearFar[0]);
}
float linearDepthFromTexture(sampler2D depthTex, vec2 uv, vec2 nearFar) {
return linearDepthFromFloat(rgba2float(texture2D(depthTex, uv)), nearFar);
}`)}},9550:(me,$,v)=>{v.d($,{Q:()=>y});var C=v(94129),W=v(97561);function y(I,U){const B=I.fragment;U.vertexTangents?(I.attributes.add("tangent","vec4"),I.varyings.add("vTangent","vec4"),B.code.add(2===U.doubleSidedMode?W.H`mat3 computeTangentSpace(vec3 normal) {
float tangentHeadedness = gl_FrontFacing ? vTangent.w : -vTangent.w;
vec3 tangent = normalize(gl_FrontFacing ? vTangent.xyz : -vTangent.xyz);
vec3 bitangent = cross(normal, tangent) * tangentHeadedness;
return mat3(tangent, bitangent, normal);
}`:W.H`mat3 computeTangentSpace(vec3 normal) {
float tangentHeadedness = vTangent.w;
vec3 tangent = normalize(vTangent.xyz);
vec3 bitangent = cross(normal, tangent) * tangentHeadedness;
return mat3(tangent, bitangent, normal);
}`)):(I.extensions.add("GL_OES_standard_derivatives"),B.code.add(W.H`mat3 computeTangentSpace(vec3 normal, vec3 pos, vec2 st) {
vec3 Q1 = dFdx(pos);
vec3 Q2 = dFdy(pos);
vec2 stx = dFdx(st);
vec2 sty = dFdy(st);
float det = stx.t * sty.s - sty.t * stx.s;
vec3 T = stx.t * Q2 - sty.t * Q1;
T = T - normal * dot(normal, T);
T *= inversesqrt(max(dot(T,T), 1.e-10));
vec3 B = sign(det) * cross(normal, T);
return mat3(T, B, normal);
}`)),0!==U.attributeTextureCoordinates&&(I.include(C.i,U),B.uniforms.add("normalTexture","sampler2D"),B.uniforms.add("normalTextureSize","vec2"),B.code.add(W.H`
    vec3 computeTextureNormal(mat3 tangentSpace, vec2 uv) {
      vtc.uv = uv;
      ${U.supportsTextureAtlas?"vtc.size = normalTextureSize;":""}
      vec3 rawNormal = textureLookup(normalTexture, vtc).rgb * 2.0 - 1.0;
      return tangentSpace * rawNormal;
    }
  `))}},66378:(me,$,v)=>{v.d($,{K:()=>W});var C=v(97561);function W(y,I){const U=y.fragment;I.receiveAmbientOcclusion?(U.uniforms.add("ssaoTex","sampler2D"),U.uniforms.add("viewportPixelSz","vec4"),U.code.add(C.H`float evaluateAmbientOcclusion() {
return 1.0 - texture2D(ssaoTex, (gl_FragCoord.xy - viewportPixelSz.xy) * viewportPixelSz.zw).a;
}
float evaluateAmbientOcclusionInverse() {
float ssao = texture2D(ssaoTex, (gl_FragCoord.xy - viewportPixelSz.xy) * viewportPixelSz.zw).a;
return viewportPixelSz.z < 0.0 ? 1.0 : ssao;
}`)):U.code.add(C.H`float evaluateAmbientOcclusion() { return 0.0; }
float evaluateAmbientOcclusionInverse() { return 1.0; }`)}},78498:(me,$,v)=>{v.d($,{X:()=>T});var C=v(97561);function W(O,x){const M=O.fragment,G=void 0!==x.lightingSphericalHarmonicsOrder?x.lightingSphericalHarmonicsOrder:2;0===G?(M.uniforms.add("lightingAmbientSH0","vec3"),M.code.add(C.H`vec3 calculateAmbientIrradiance(vec3 normal, float ambientOcclusion) {
vec3 ambientLight = 0.282095 * lightingAmbientSH0;
return ambientLight * (1.0 - ambientOcclusion);
}`)):1===G?(M.uniforms.add("lightingAmbientSH_R","vec4"),M.uniforms.add("lightingAmbientSH_G","vec4"),M.uniforms.add("lightingAmbientSH_B","vec4"),M.code.add(C.H`vec3 calculateAmbientIrradiance(vec3 normal, float ambientOcclusion) {
vec4 sh0 = vec4(
0.282095,
0.488603 * normal.x,
0.488603 * normal.z,
0.488603 * normal.y
);
vec3 ambientLight = vec3(
dot(lightingAmbientSH_R, sh0),
dot(lightingAmbientSH_G, sh0),
dot(lightingAmbientSH_B, sh0)
);
return ambientLight * (1.0 - ambientOcclusion);
}`)):2===G&&(M.uniforms.add("lightingAmbientSH0","vec3"),M.uniforms.add("lightingAmbientSH_R1","vec4"),M.uniforms.add("lightingAmbientSH_G1","vec4"),M.uniforms.add("lightingAmbientSH_B1","vec4"),M.uniforms.add("lightingAmbientSH_R2","vec4"),M.uniforms.add("lightingAmbientSH_G2","vec4"),M.uniforms.add("lightingAmbientSH_B2","vec4"),M.code.add(C.H`vec3 calculateAmbientIrradiance(vec3 normal, float ambientOcclusion) {
vec3 ambientLight = 0.282095 * lightingAmbientSH0;
vec4 sh1 = vec4(
0.488603 * normal.x,
0.488603 * normal.z,
0.488603 * normal.y,
1.092548 * normal.x * normal.y
);
vec4 sh2 = vec4(
1.092548 * normal.y * normal.z,
0.315392 * (3.0 * normal.z * normal.z - 1.0),
1.092548 * normal.x * normal.z,
0.546274 * (normal.x * normal.x - normal.y * normal.y)
);
ambientLight += vec3(
dot(lightingAmbientSH_R1, sh1),
dot(lightingAmbientSH_G1, sh1),
dot(lightingAmbientSH_B1, sh1)
);
ambientLight += vec3(
dot(lightingAmbientSH_R2, sh2),
dot(lightingAmbientSH_G2, sh2),
dot(lightingAmbientSH_B2, sh2)
);
return ambientLight * (1.0 - ambientOcclusion);
}`),1!==x.pbrMode&&2!==x.pbrMode||M.code.add(C.H`const vec3 skyTransmittance = vec3(0.9, 0.9, 1.0);
vec3 calculateAmbientRadiance(float ambientOcclusion)
{
vec3 ambientLight = 1.2 * (0.282095 * lightingAmbientSH0) - 0.2;
return ambientLight *= (1.0 - ambientOcclusion) * skyTransmittance;
}`))}var y=v(66378);function I(O){const x=O.fragment;x.uniforms.add("lightingMainDirection","vec3"),x.uniforms.add("lightingMainIntensity","vec3"),x.uniforms.add("lightingFixedFactor","float"),x.code.add(C.H`vec3 evaluateMainLighting(vec3 normal_global, float shadowing) {
float dotVal = clamp(dot(normal_global, lightingMainDirection), 0.0, 1.0);
dotVal = mix(dotVal, 1.0, lightingFixedFactor);
return lightingMainIntensity * ((1.0 - shadowing) * dotVal);
}`)}var U=v(87954),B=v(20367),P=v(98845);function T(O,x){const M=O.fragment;O.include(I),O.include(y.K,x),0!==x.pbrMode&&O.include(U.T,x),O.include(W,x),x.receiveShadows&&O.include(P.hX,x),M.uniforms.add("lightingGlobalFactor","float"),M.uniforms.add("ambientBoostFactor","float"),O.include(B.e),M.code.add(C.H`
    const float GAMMA_SRGB = 2.1;
    const float INV_GAMMA_SRGB = 0.4761904;
    ${0===x.pbrMode?"":"const vec3 GROUND_REFLECTANCE = vec3(0.2);"}
  `),M.code.add(C.H`
    float additionalDirectedAmbientLight(vec3 vPosWorld) {
      float vndl = dot(${1===x.viewingMode?C.H`normalize(vPosWorld)`:C.H`vec3(0.0, 0.0, 1.0)`}, lightingMainDirection);
      return smoothstep(0.0, 1.0, clamp(vndl * 2.5, 0.0, 1.0));
    }
  `),M.code.add(C.H`vec3 evaluateAdditionalLighting(float ambientOcclusion, vec3 vPosWorld) {
float additionalAmbientScale = additionalDirectedAmbientLight(vPosWorld);
return (1.0 - ambientOcclusion) * additionalAmbientScale * ambientBoostFactor * lightingGlobalFactor * lightingMainIntensity;
}`),0===x.pbrMode||4===x.pbrMode?M.code.add(C.H`vec3 evaluateSceneLighting(vec3 normalWorld, vec3 albedo, float shadow, float ssao, vec3 additionalLight)
{
vec3 mainLighting = evaluateMainLighting(normalWorld, shadow);
vec3 ambientLighting = calculateAmbientIrradiance(normalWorld, ssao);
vec3 albedoLinear = pow(albedo, vec3(GAMMA_SRGB));
vec3 totalLight = mainLighting + ambientLighting + additionalLight;
totalLight = min(totalLight, vec3(PI));
vec3 outColor = vec3((albedoLinear / PI) * totalLight);
return pow(outColor, vec3(INV_GAMMA_SRGB));
}`):1!==x.pbrMode&&2!==x.pbrMode||(M.code.add(C.H`const float fillLightIntensity = 0.25;
const float horizonLightDiffusion = 0.4;
const float additionalAmbientIrradianceFactor = 0.02;
vec3 evaluateSceneLightingPBR(vec3 normal, vec3 albedo, float shadow, float ssao, vec3 additionalLight, vec3 viewDir, vec3 normalGround, vec3 mrr, vec3 _emission, float additionalAmbientIrradiance)
{
vec3 viewDirection = -viewDir;
vec3 mainLightDirection = lightingMainDirection;
vec3 h = normalize(viewDirection + mainLightDirection);
PBRShadingInfo inputs;
inputs.NdotL = clamp(dot(normal, mainLightDirection), 0.001, 1.0);
inputs.NdotV = clamp(abs(dot(normal, viewDirection)), 0.001, 1.0);
inputs.NdotH = clamp(dot(normal, h), 0.0, 1.0);
inputs.VdotH = clamp(dot(viewDirection, h), 0.0, 1.0);
inputs.NdotNG = clamp(dot(normal, normalGround), -1.0, 1.0);
vec3 reflectedView = normalize(reflect(viewDirection, normal));
inputs.RdotNG = clamp(dot(reflectedView, normalGround), -1.0, 1.0);
inputs.albedoLinear = pow(albedo, vec3(GAMMA_SRGB));
inputs.ssao = ssao;
inputs.metalness = mrr[0];
inputs.roughness = clamp(mrr[1] * mrr[1], 0.001, 0.99);`),M.code.add(C.H`inputs.f0 = (0.16 * mrr[2] * mrr[2]) * (1.0 - inputs.metalness) + inputs.albedoLinear * inputs.metalness;
inputs.f90 = vec3(clamp(dot(inputs.f0, vec3(50.0 * 0.33)), 0.0, 1.0));
inputs.diffuseColor = inputs.albedoLinear * (vec3(1.0) - inputs.f0) * (1.0 - inputs.metalness);`),M.code.add(C.H`vec3 ambientDir = vec3(5.0 * normalGround[1] - normalGround[0] * normalGround[2], - 5.0 * normalGround[0] - normalGround[2] * normalGround[1], normalGround[1] * normalGround[1] + normalGround[0] * normalGround[0]);
ambientDir = ambientDir != vec3(0.0)? normalize(ambientDir) : normalize(vec3(5.0, -1.0, 0.0));
inputs.NdotAmbDir = abs(dot(normal, ambientDir));
vec3 mainLightIrradianceComponent = inputs.NdotL * (1.0 - shadow) * lightingMainIntensity;
vec3 fillLightsIrradianceComponent = inputs.NdotAmbDir * lightingMainIntensity * fillLightIntensity;
vec3 ambientLightIrradianceComponent = calculateAmbientIrradiance(normal, ssao) + additionalLight;
inputs.skyIrradianceToSurface = ambientLightIrradianceComponent + mainLightIrradianceComponent + fillLightsIrradianceComponent ;
inputs.groundIrradianceToSurface = GROUND_REFLECTANCE * ambientLightIrradianceComponent + mainLightIrradianceComponent + fillLightsIrradianceComponent ;`),M.code.add(C.H`vec3 horizonRingDir = inputs.RdotNG * normalGround - reflectedView;
vec3 horizonRingH = normalize(viewDirection + horizonRingDir);
inputs.NdotH_Horizon = dot(normal, horizonRingH);
vec3 mainLightRadianceComponent = normalDistribution(inputs.NdotH, inputs.roughness) * lightingMainIntensity * (1.0 - shadow);
vec3 horizonLightRadianceComponent = normalDistribution(inputs.NdotH_Horizon, min(inputs.roughness + horizonLightDiffusion, 1.0)) * lightingMainIntensity * fillLightIntensity;
vec3 ambientLightRadianceComponent = calculateAmbientRadiance(ssao) + additionalLight;
inputs.skyRadianceToSurface = ambientLightRadianceComponent + mainLightRadianceComponent + horizonLightRadianceComponent;
inputs.groundRadianceToSurface = GROUND_REFLECTANCE * (ambientLightRadianceComponent + horizonLightRadianceComponent) + mainLightRadianceComponent;
inputs.averageAmbientRadiance = ambientLightIrradianceComponent[1] * (1.0 + GROUND_REFLECTANCE[1]);`),M.code.add(C.H`
        vec3 reflectedColorComponent = evaluateEnvironmentIllumination(inputs);
        vec3 additionalMaterialReflectanceComponent = inputs.albedoLinear * additionalAmbientIrradiance;
        vec3 emissionComponent = pow(_emission, vec3(GAMMA_SRGB));
        vec3 outColorLinear = reflectedColorComponent + additionalMaterialReflectanceComponent + emissionComponent;
        ${2===x.pbrMode?C.H`vec3 outColor = pow(max(vec3(0.0), outColorLinear - 0.005 * inputs.averageAmbientRadiance), vec3(INV_GAMMA_SRGB));`:C.H`vec3 outColor = pow(blackLevelSoftCompression(outColorLinear, inputs), vec3(INV_GAMMA_SRGB));`}
        return outColor;
      }
    `))}},70946:(me,$,v)=>{v.d($,{p:()=>y,l:()=>W});var C=v(97561);function W(I,U){I.fragment.uniforms.add("terrainDepthTexture","sampler2D"),I.fragment.uniforms.add("cameraNearFar","vec2"),I.fragment.uniforms.add("inverseViewport","vec2"),I.fragment.code.add(C.H`
    // Compare the linearized depths of fragment and terrain. Discard fragments on the wrong side of the terrain.
    void terrainDepthTest(vec4 fragCoord, float fragmentDepth){

      float terrainDepth = linearDepthFromTexture(terrainDepthTexture, fragCoord.xy * inverseViewport, cameraNearFar);
      if(fragmentDepth ${U.cullAboveGround?">":"<="} terrainDepth){
        discard;
      }
    }
  `)}function y(I,U){U.multipassTerrainEnabled&&U.terrainLinearDepthTexture&&I.bindTexture(U.terrainLinearDepthTexture,"terrainDepthTexture")}},73403:(me,$,v)=>{v.d($,{k:()=>W});var C=v(97561);function W(y,I){const U=y.fragment;U.code.add(C.H`struct ShadingNormalParameters {
vec3 normalView;
vec3 viewDirection;
} shadingParams;`),U.code.add(1===I.doubleSidedMode?C.H`vec3 shadingNormal(ShadingNormalParameters params) {
return dot(params.normalView, params.viewDirection) > 0.0 ? normalize(-params.normalView) : normalize(params.normalView);
}`:2===I.doubleSidedMode?C.H`vec3 shadingNormal(ShadingNormalParameters params) {
return gl_FrontFacing ? normalize(params.normalView) : normalize(-params.normalView);
}`:C.H`vec3 shadingNormal(ShadingNormalParameters params) {
return normalize(params.normalView);
}`)}},87954:(me,$,v)=>{v.d($,{T:()=>I});var C=v(97561);function W(U){const B=U.fragment.code;B.add(C.H`vec3 evaluateDiffuseIlluminationHemisphere(vec3 ambientGround, vec3 ambientSky, float NdotNG)
{
return ((1.0 - NdotNG) * ambientGround + (1.0 + NdotNG) * ambientSky) * 0.5;
}`),B.add(C.H`float integratedRadiance(float cosTheta2, float roughness)
{
return (cosTheta2 - 1.0) / (cosTheta2 * (1.0 - roughness * roughness) - 1.0);
}`),B.add(C.H`vec3 evaluateSpecularIlluminationHemisphere(vec3 ambientGround, vec3 ambientSky, float RdotNG, float roughness)
{
float cosTheta2 = 1.0 - RdotNG * RdotNG;
float intRadTheta = integratedRadiance(cosTheta2, roughness);
float ground = RdotNG < 0.0 ? 1.0 - intRadTheta : 1.0 + intRadTheta;
float sky = 2.0 - ground;
return (ground * ambientGround + sky * ambientSky) * 0.5;
}`)}var y=v(20367);function I(U,B){const P=U.fragment.code;U.include(y.e),3===B.pbrMode||4===B.pbrMode?(P.add(C.H`
    struct PBRShadingWater
    {
        float NdotL;   // cos angle between normal and light direction
        float NdotV;   // cos angle between normal and view direction
        float NdotH;   // cos angle between normal and half vector
        float VdotH;   // cos angle between view direction and half vector
        float LdotH;   // cos angle between light direction and half vector
        float VdotN;   // cos angle between view direction and normal vector
    };

    float dtrExponent = ${B.useCustomDTRExponentForWater?"2.2":"2.0"};
    `),P.add(C.H`vec3 fresnelReflection(float angle, vec3 f0, float f90) {
return f0 + (f90 - f0) * pow(1.0 - angle, 5.0);
}`),P.add(C.H`float normalDistributionWater(float NdotH, float roughness)
{
float r2 = roughness * roughness;
float NdotH2 = NdotH * NdotH;
float denom = pow((NdotH2 * (r2 - 1.0) + 1.0), dtrExponent) * PI;
return r2 / denom;
}`),P.add(C.H`float geometricOcclusionKelemen(float LoH)
{
return 0.25 / (LoH * LoH);
}`),P.add(C.H`vec3 brdfSpecularWater(in PBRShadingWater props, float roughness, vec3 F0, float F0Max)
{
vec3  F = fresnelReflection(props.VdotH, F0, F0Max);
float dSun = normalDistributionWater(props.NdotH, roughness);
float V = geometricOcclusionKelemen(props.LdotH);
float diffusionSunHaze = mix(roughness + 0.045, roughness + 0.385, 1.0 - props.VdotH);
float strengthSunHaze  = 1.2;
float dSunHaze = normalDistributionWater(props.NdotH, diffusionSunHaze)*strengthSunHaze;
return ((dSun + dSunHaze) * V) * F;
}
vec3 tonemapACES(const vec3 x) {
return (x * (2.51 * x + 0.03)) / (x * (2.43 * x + 0.59) + 0.14);
}`)):1!==B.pbrMode&&2!==B.pbrMode||(U.include(W),P.add(C.H`struct PBRShadingInfo
{
float NdotL;
float NdotV;
float NdotH;
float VdotH;
float LdotH;
float NdotNG;
float RdotNG;
float NdotAmbDir;
float NdotH_Horizon;
vec3 skyRadianceToSurface;
vec3 groundRadianceToSurface;
vec3 skyIrradianceToSurface;
vec3 groundIrradianceToSurface;
float averageAmbientRadiance;
float ssao;
vec3 albedoLinear;
vec3 f0;
vec3 f90;
vec3 diffuseColor;
float metalness;
float roughness;
};`),P.add(C.H`float normalDistribution(float NdotH, float roughness)
{
float a = NdotH * roughness;
float b = roughness / (1.0 - NdotH * NdotH + a * a);
return b * b * INV_PI;
}`),P.add(C.H`const vec4 c0 = vec4(-1.0, -0.0275, -0.572,  0.022);
const vec4 c1 = vec4( 1.0,  0.0425,  1.040, -0.040);
const vec2 c2 = vec2(-1.04, 1.04);
vec2 prefilteredDFGAnalytical(float roughness, float NdotV) {
vec4 r = roughness * c0 + c1;
float a004 = min(r.x * r.x, exp2(-9.28 * NdotV)) * r.x + r.y;
return c2 * a004 + r.zw;
}`),P.add(C.H`vec3 evaluateEnvironmentIllumination(PBRShadingInfo inputs) {
vec3 indirectDiffuse = evaluateDiffuseIlluminationHemisphere(inputs.groundIrradianceToSurface, inputs.skyIrradianceToSurface, inputs.NdotNG);
vec3 indirectSpecular = evaluateSpecularIlluminationHemisphere(inputs.groundRadianceToSurface, inputs.skyRadianceToSurface, inputs.RdotNG, inputs.roughness);
vec3 diffuseComponent = inputs.diffuseColor * indirectDiffuse * INV_PI;
vec2 dfg = prefilteredDFGAnalytical(inputs.roughness, inputs.NdotV);
vec3 specularColor = inputs.f0 * dfg.x + inputs.f90 * dfg.y;
vec3 specularComponent = specularColor * indirectSpecular;
return (diffuseComponent + specularComponent);
}`),P.add(C.H`float gamutMapChanel(float x, vec2 p){
return (x < p.x) ? mix(0.0, p.y, x/p.x) : mix(p.y, 1.0, (x - p.x) / (1.0 - p.x) );
}`),P.add(C.H`vec3 blackLevelSoftCompression(vec3 inColor, PBRShadingInfo inputs){
vec3 outColor;
vec2 p = vec2(0.02 * (inputs.averageAmbientRadiance), 0.0075 * (inputs.averageAmbientRadiance));
outColor.x = gamutMapChanel(inColor.x, p) ;
outColor.y = gamutMapChanel(inColor.y, p) ;
outColor.z = gamutMapChanel(inColor.z, p) ;
return outColor;
}`))}},51277:(me,$,v)=>{v.d($,{jV:()=>U,nW:()=>B});var C=v(78522),W=v(94129),y=v(97561);function U(P,T){const O=P.fragment,x=T.hasMetalnessAndRoughnessTexture||T.hasEmissionTexture||T.hasOcclusionTexture;1===T.pbrMode&&x&&P.include(W.i,T),2!==T.pbrMode?(0===T.pbrMode&&O.code.add(y.H`float getBakedOcclusion() { return 1.0; }`),1===T.pbrMode&&(O.uniforms.add("emissionFactor","vec3"),O.uniforms.add("mrrFactors","vec3"),O.code.add(y.H`vec3 mrr;
vec3 emission;
float occlusion;`),T.hasMetalnessAndRoughnessTexture&&(O.uniforms.add("texMetallicRoughness","sampler2D"),T.supportsTextureAtlas&&O.uniforms.add("texMetallicRoughnessSize","vec2"),O.code.add(y.H`void applyMetallnessAndRoughness(TextureLookupParameter params) {
vec3 metallicRoughness = textureLookup(texMetallicRoughness, params).rgb;
mrr[0] *= metallicRoughness.b;
mrr[1] *= metallicRoughness.g;
}`)),T.hasEmissionTexture&&(O.uniforms.add("texEmission","sampler2D"),T.supportsTextureAtlas&&O.uniforms.add("texEmissionSize","vec2"),O.code.add(y.H`void applyEmission(TextureLookupParameter params) {
emission *= textureLookup(texEmission, params).rgb;
}`)),T.hasOcclusionTexture?(O.uniforms.add("texOcclusion","sampler2D"),T.supportsTextureAtlas&&O.uniforms.add("texOcclusionSize","vec2"),O.code.add(y.H`void applyOcclusion(TextureLookupParameter params) {
occlusion *= textureLookup(texOcclusion, params).r;
}
float getBakedOcclusion() {
return occlusion;
}`)):O.code.add(y.H`float getBakedOcclusion() { return 1.0; }`),O.code.add(y.H`
    void applyPBRFactors() {
      mrr = mrrFactors;
      emission = emissionFactor;
      occlusion = 1.0;
      ${x?"vtc.uv = vuv0;":""}
      ${T.hasMetalnessAndRoughnessTexture?T.supportsTextureAtlas?"vtc.size = texMetallicRoughnessSize; applyMetallnessAndRoughness(vtc);":"applyMetallnessAndRoughness(vtc);":""}
      ${T.hasEmissionTexture?T.supportsTextureAtlas?"vtc.size = texEmissionSize; applyEmission(vtc);":"applyEmission(vtc);":""}
      ${T.hasOcclusionTexture?T.supportsTextureAtlas?"vtc.size = texOcclusionSize; applyOcclusion(vtc);":"applyOcclusion(vtc);":""}
    }
  `))):O.code.add(y.H`const vec3 mrr = vec3(0.0, 0.6, 0.2);
const vec3 emission = vec3(0.0);
float occlusion = 1.0;
void applyPBRFactors() {}
float getBakedOcclusion() { return 1.0; }`)}function B(P,T,O=!1){O||(P.setUniform3fv("mrrFactors",T.mrrFactors),P.setUniform3fv("emissionFactor",T.emissiveFactor))}(0,C.f)(0,.6,.2)},20367:(me,$,v)=>{v.d($,{e:()=>W});var C=v(97561);function W(y){y.vertex.code.add(C.H`const float PI = 3.141592653589793;`),y.fragment.code.add(C.H`const float PI = 3.141592653589793;
const float LIGHT_NORMALIZATION = 1.0 / PI;
const float INV_PI = 0.3183098861837907;
const float HALF_PI = 1.570796326794897;`)}},98845:(me,$,v)=>{v.d($,{hX:()=>y,vL:()=>U});var C=v(5190),W=v(97561);function y(P){P.fragment.include(C.n),P.fragment.uniforms.add("uShadowMapTex","sampler2D"),P.fragment.uniforms.add("uShadowMapNum","int"),P.fragment.uniforms.add("uShadowMapDistance","vec4"),P.fragment.uniforms.add("uShadowMapMatrix","mat4",4),P.fragment.uniforms.add("uDepthHalfPixelSz","float"),P.fragment.code.add(W.H`int chooseCascade(float _linearDepth, out mat4 mat) {
vec4 distance = uShadowMapDistance;
float depth = _linearDepth;
int i = depth < distance[1] ? 0 : depth < distance[2] ? 1 : depth < distance[3] ? 2 : 3;
mat = i == 0 ? uShadowMapMatrix[0] : i == 1 ? uShadowMapMatrix[1] : i == 2 ? uShadowMapMatrix[2] : uShadowMapMatrix[3];
return i;
}
vec3 lightSpacePosition(vec3 _vpos, mat4 mat) {
vec4 lv = mat * vec4(_vpos, 1.0);
lv.xy /= lv.w;
return 0.5 * lv.xyz + vec3(0.5);
}
vec2 cascadeCoordinates(int i, vec3 lvpos) {
return vec2(float(i - 2 * (i / 2)) * 0.5, float(i / 2) * 0.5) + 0.5 * lvpos.xy;
}
float readShadowMapDepth(vec2 uv, sampler2D _depthTex) {
return rgba2float(texture2D(_depthTex, uv));
}
float posIsInShadow(vec2 uv, vec3 lvpos, sampler2D _depthTex) {
return readShadowMapDepth(uv, _depthTex) < lvpos.z ? 1.0 : 0.0;
}
float filterShadow(vec2 uv, vec3 lvpos, float halfPixelSize, sampler2D _depthTex) {
float texSize = 0.5 / halfPixelSize;
vec2 st = fract((vec2(halfPixelSize) + uv) * texSize);
float s00 = posIsInShadow(uv + vec2(-halfPixelSize, -halfPixelSize), lvpos, _depthTex);
float s10 = posIsInShadow(uv + vec2(halfPixelSize, -halfPixelSize), lvpos, _depthTex);
float s11 = posIsInShadow(uv + vec2(halfPixelSize, halfPixelSize), lvpos, _depthTex);
float s01 = posIsInShadow(uv + vec2(-halfPixelSize, halfPixelSize), lvpos, _depthTex);
return mix(mix(s00, s10, st.x), mix(s01, s11, st.x), st.y);
}
float readShadowMap(const in vec3 _vpos, float _linearDepth) {
mat4 mat;
int i = chooseCascade(_linearDepth, mat);
if (i >= uShadowMapNum) { return 0.0; }
vec3 lvpos = lightSpacePosition(_vpos, mat);
if (lvpos.z >= 1.0) { return 0.0; }
if (lvpos.x < 0.0 || lvpos.x > 1.0 || lvpos.y < 0.0 || lvpos.y > 1.0) { return 0.0; }
vec2 uv = cascadeCoordinates(i, lvpos);
return filterShadow(uv, lvpos, uDepthHalfPixelSz, uShadowMapTex);
}`)}function U(P,T,O){T.shadowMappingEnabled&&T.shadowMap.bindView(P,O)}},73184:(me,$,v)=>{v.d($,{kl:()=>W,uj:()=>U});var C=v(97561);function W(B,P){P.vvInstancingEnabled&&(P.vvSize||P.vvColor)&&B.attributes.add("instanceFeatureAttribute","vec4"),P.vvSize?(B.vertex.uniforms.add("vvSizeMinSize","vec3"),B.vertex.uniforms.add("vvSizeMaxSize","vec3"),B.vertex.uniforms.add("vvSizeOffset","vec3"),B.vertex.uniforms.add("vvSizeFactor","vec3"),B.vertex.uniforms.add("vvSymbolRotationMatrix","mat3"),B.vertex.uniforms.add("vvSymbolAnchor","vec3"),B.vertex.code.add(C.H`vec3 vvScale(vec4 _featureAttribute) {
return clamp(vvSizeOffset + _featureAttribute.x * vvSizeFactor, vvSizeMinSize, vvSizeMaxSize);
}
vec4 vvTransformPosition(vec3 position, vec4 _featureAttribute) {
return vec4(vvSymbolRotationMatrix * ( vvScale(_featureAttribute) * (position + vvSymbolAnchor)), 1.0);
}`),B.vertex.code.add(C.H`
      const float eps = 1.192092896e-07;
      vec4 vvTransformNormal(vec3 _normal, vec4 _featureAttribute) {
        vec3 vvScale = clamp(vvSizeOffset + _featureAttribute.x * vvSizeFactor, vvSizeMinSize + eps, vvSizeMaxSize);
        return vec4(vvSymbolRotationMatrix * _normal / vvScale, 1.0);
      }

      ${P.vvInstancingEnabled?C.H`
      vec4 vvLocalNormal(vec3 _normal) {
        return vvTransformNormal(_normal, instanceFeatureAttribute);
      }

      vec4 localPosition() {
        return vvTransformPosition(position, instanceFeatureAttribute);
      }`:""}
    `)):B.vertex.code.add(C.H`vec4 localPosition() { return vec4(position, 1.0); }
vec4 vvLocalNormal(vec3 _normal) { return vec4(_normal, 1.0); }`),P.vvColor?(B.vertex.constants.add("vvColorNumber","int",8),B.vertex.code.add(C.H`
      uniform float vvColorValues[vvColorNumber];
      uniform vec4 vvColorColors[vvColorNumber];

      vec4 vvGetColor(vec4 featureAttribute, float values[vvColorNumber], vec4 colors[vvColorNumber]) {
        float value = featureAttribute.y;
        if (value <= values[0]) {
          return colors[0];
        }

        for (int i = 1; i < vvColorNumber; ++i) {
          if (values[i] >= value) {
            float f = (value - values[i-1]) / (values[i] - values[i-1]);
            return mix(colors[i-1], colors[i], f);
          }
        }
        return colors[vvColorNumber - 1];
      }

      ${P.vvInstancingEnabled?C.H`
      vec4 vvColor() {
        return vvGetColor(instanceFeatureAttribute, vvColorValues, vvColorColors);
      }`:""}
    `)):B.vertex.code.add(C.H`vec4 vvColor() { return vec4(1.0); }`)}function U(B,P){(function(B,P){P.vvSizeEnabled&&(B.setUniform3fv("vvSizeMinSize",P.vvSizeMinSize),B.setUniform3fv("vvSizeMaxSize",P.vvSizeMaxSize),B.setUniform3fv("vvSizeOffset",P.vvSizeOffset),B.setUniform3fv("vvSizeFactor",P.vvSizeFactor)),P.vvColorEnabled&&(B.setUniform1fv("vvColorValues",P.vvColorValues),B.setUniform4fv("vvColorColors",P.vvColorColors))})(B,P),P.vvSizeEnabled&&(B.setUniform3fv("vvSymbolAnchor",P.vvSymbolAnchor),B.setUniformMatrix3fv("vvSymbolRotationMatrix",P.vvSymbolRotationMatrix))}},38238:(me,$,v)=>{v.d($,{sj:()=>I,F:()=>W,bf:()=>y});var C=v(97561);const W=.1,y=.001;function I(U,B){const P=U.fragment;switch(B.alphaDiscardMode){case 0:P.code.add(C.H`
        #define discardOrAdjustAlpha(color) { if (color.a < ${C.H.float(y)}) { discard; } }
      `);break;case 1:P.code.add(C.H`void discardOrAdjustAlpha(inout vec4 color) {
color.a = 1.0;
}`);break;case 2:P.uniforms.add("textureAlphaCutoff","float"),P.code.add(C.H`#define discardOrAdjustAlpha(color) { if (color.a < textureAlphaCutoff) { discard; } else { color.a = 1.0; } }`);break;case 3:U.fragment.uniforms.add("textureAlphaCutoff","float"),U.fragment.code.add(C.H`#define discardOrAdjustAlpha(color) { if (color.a < textureAlphaCutoff) { discard; } }`)}}},20865:(me,$,v)=>{v.d($,{$:()=>ie,I:()=>de});var ne,se,C=v(67474),W=v(97561),y=v(60305),I=v(10127),U=v(26436),B=v(27001),P=v(25558),x=(v(40150),v(36320),v(82705)),G=(v(13006),v(48082)),k=v(28258),K=v(48557),Y=v(42683),Pe={exports:{}};ne=Pe,void 0!==(se=function(){var ee={enable:{1:{0:!0}},disable:{1:{0:!0}},getParameter:{1:{0:!0}},drawArrays:{3:{0:!0}},drawElements:{4:{0:!0,2:!0}},createShader:{1:{0:!0}},getShaderParameter:{2:{1:!0}},getProgramParameter:{2:{1:!0}},getShaderPrecisionFormat:{2:{0:!0,1:!0}},getVertexAttrib:{2:{1:!0}},vertexAttribPointer:{6:{2:!0}},bindTexture:{2:{0:!0}},activeTexture:{1:{0:!0}},getTexParameter:{2:{0:!0,1:!0}},texParameterf:{3:{0:!0,1:!0}},texParameteri:{3:{0:!0,1:!0,2:!0}},texImage2D:{9:{0:!0,2:!0,6:!0,7:!0},6:{0:!0,2:!0,3:!0,4:!0}},texSubImage2D:{9:{0:!0,6:!0,7:!0},7:{0:!0,4:!0,5:!0}},copyTexImage2D:{8:{0:!0,2:!0}},copyTexSubImage2D:{8:{0:!0}},generateMipmap:{1:{0:!0}},compressedTexImage2D:{7:{0:!0,2:!0}},compressedTexSubImage2D:{8:{0:!0,6:!0}},bindBuffer:{2:{0:!0}},bufferData:{3:{0:!0,2:!0}},bufferSubData:{3:{0:!0}},getBufferParameter:{2:{0:!0,1:!0}},pixelStorei:{2:{0:!0,1:!0}},readPixels:{7:{4:!0,5:!0}},bindRenderbuffer:{2:{0:!0}},bindFramebuffer:{2:{0:!0}},checkFramebufferStatus:{1:{0:!0}},framebufferRenderbuffer:{4:{0:!0,1:!0,2:!0}},framebufferTexture2D:{5:{0:!0,1:!0,2:!0}},getFramebufferAttachmentParameter:{3:{0:!0,1:!0,2:!0}},getRenderbufferParameter:{2:{0:!0,1:!0}},renderbufferStorage:{4:{0:!0,1:!0}},clear:{1:{0:{enumBitwiseOr:["COLOR_BUFFER_BIT","DEPTH_BUFFER_BIT","STENCIL_BUFFER_BIT"]}}},depthFunc:{1:{0:!0}},blendFunc:{2:{0:!0,1:!0}},blendFuncSeparate:{4:{0:!0,1:!0,2:!0,3:!0}},blendEquation:{1:{0:!0}},blendEquationSeparate:{2:{0:!0,1:!0}},stencilFunc:{3:{0:!0}},stencilFuncSeparate:{4:{0:!0,1:!0}},stencilMaskSeparate:{2:{0:!0}},stencilOp:{3:{0:!0,1:!0,2:!0}},stencilOpSeparate:{4:{0:!0,1:!0,2:!0,3:!0}},cullFace:{1:{0:!0}},frontFace:{1:{0:!0}},drawArraysInstancedANGLE:{4:{0:!0}},drawElementsInstancedANGLE:{5:{0:!0,2:!0}},blendEquationEXT:{1:{0:!0}}},ue=null,tt=null;function nt(b){if(null==ue)for(var X in ue={},tt={},b)"number"==typeof b[X]&&(ue[b[X]]=X,tt[X]=b[X])}function ut(){if(null==ue)throw"WebGLDebugUtils.init(ctx) not called"}function Ee(b){ut();var X=ue[b];return void 0!==X?"gl."+X:"/*UNKNOWN WebGL ENUM*/ 0x"+b.toString(16)}function Ye(b,X,A,D){var H;if(void 0!==(H=ee[b])&&void 0!==(H=H[X])&&H[A]){if("object"==typeof H[A]&&void 0!==H[A].enumBitwiseOr){for(var N=H[A].enumBitwiseOr,Q=0,te=[],ge=0;ge<N.length;++ge){var fe=tt[N[ge]];0!=(D&fe)&&(Q|=fe,te.push(Ee(fe)))}return Q===D?te.join(" | "):Ee(D)}return Ee(D)}return null===D?"null":void 0===D?"undefined":D.toString()}function yt(b,X,A){b.__defineGetter__(A,function(){return X[A]}),b.__defineSetter__(A,function(D){X[A]=D})}function Et(b){var X=b.getParameter(b.MAX_VERTEX_ATTRIBS),A=b.createBuffer();b.bindBuffer(b.ARRAY_BUFFER,A);for(var D=0;D<X;++D)b.disableVertexAttribArray(D),b.vertexAttribPointer(D,4,b.FLOAT,!1,0,0),b.vertexAttrib1f(D,0);b.deleteBuffer(A);var H=b.getParameter(b.MAX_TEXTURE_IMAGE_UNITS);for(D=0;D<H;++D)b.activeTexture(b.TEXTURE0+D),b.bindTexture(b.TEXTURE_CUBE_MAP,null),b.bindTexture(b.TEXTURE_2D,null);for(b.activeTexture(b.TEXTURE0),b.useProgram(null),b.bindBuffer(b.ARRAY_BUFFER,null),b.bindBuffer(b.ELEMENT_ARRAY_BUFFER,null),b.bindFramebuffer(b.FRAMEBUFFER,null),b.bindRenderbuffer(b.RENDERBUFFER,null),b.disable(b.BLEND),b.disable(b.CULL_FACE),b.disable(b.DEPTH_TEST),b.disable(b.DITHER),b.disable(b.SCISSOR_TEST),b.blendColor(0,0,0,0),b.blendEquation(b.FUNC_ADD),b.blendFunc(b.ONE,b.ZERO),b.clearColor(0,0,0,0),b.clearDepth(1),b.clearStencil(-1),b.colorMask(!0,!0,!0,!0),b.cullFace(b.BACK),b.depthFunc(b.LESS),b.depthMask(!0),b.depthRange(0,1),b.frontFace(b.CCW),b.hint(b.GENERATE_MIPMAP_HINT,b.DONT_CARE),b.lineWidth(1),b.pixelStorei(b.PACK_ALIGNMENT,4),b.pixelStorei(b.UNPACK_ALIGNMENT,4),b.pixelStorei(b.UNPACK_FLIP_Y_WEBGL,!1),b.pixelStorei(b.UNPACK_PREMULTIPLY_ALPHA_WEBGL,!1),b.UNPACK_COLORSPACE_CONVERSION_WEBGL&&b.pixelStorei(b.UNPACK_COLORSPACE_CONVERSION_WEBGL,b.BROWSER_DEFAULT_WEBGL),b.polygonOffset(0,0),b.sampleCoverage(1,!1),b.scissor(0,0,b.canvas.width,b.canvas.height),b.stencilFunc(b.ALWAYS,0,4294967295),b.stencilMask(4294967295),b.stencilOp(b.KEEP,b.KEEP,b.KEEP),b.viewport(0,0,b.canvas.width,b.canvas.height),b.clear(b.COLOR_BUFFER_BIT|b.DEPTH_BUFFER_BIT|b.STENCIL_BUFFER_BIT);b.getError(););}return{init:nt,mightBeEnum:function(b){return ut(),void 0!==ue[b]},glEnumToString:Ee,glFunctionArgToString:Ye,glFunctionArgsToString:function(b,X){for(var A="",D=X.length,H=0;H<D;++H)A+=(0==H?"":", ")+Ye(b,D,H,X[H]);return A},makeDebugContext:function bt(b,X,A,D){D=D||b,nt(b),X=X||function(fe,xe,He){for(var ze="",Qe=He.length,F=0;F<Qe;++F)ze+=(0==F?"":", ")+Ye(xe,Qe,F,He[F]);!function(b){window.console&&window.console.error?window.console.error(b):function(b){window.console&&window.console.log&&window.console.log(b)}(b)}("WebGL error "+Ee(fe)+" in "+xe+"("+ze+")")};var H={};function N(fe,xe){return function(){A&&A(xe,arguments);var He=fe[xe].apply(fe,arguments),ze=D.getError();return 0!=ze&&(H[ze]=!0,X(ze,xe,arguments)),He}}var Q={};for(var te in b)if("function"==typeof b[te])if("getExtension"!=te)Q[te]=N(b,te);else{var ge=N(b,te);Q[te]=function(){return bt(ge.apply(b,arguments),X,A,D)}}else yt(Q,b,te);return Q.getError=function(){for(var fe in H)if(H.hasOwnProperty(fe)&&H[fe])return H[fe]=!1,fe;return b.NO_ERROR},Q},makeLostContextSimulatingCanvas:function(b){var X,A,D=[],H=[],N={},Q=1,te=!1,ge=[],fe=0,xe=0,He=!1,ze=0,Qe={};function F(ae){return"function"==typeof ae?ae:function(pe){ae.handleEvent(pe)}}b.getContext=(A=b.getContext,function(){var ae=A.apply(b,arguments);if(ae instanceof WebGLRenderingContext){if(ae!=X){if(X)throw"got different context";N=ye(X=ae)}return N}return ae});var ae,pe,z=function(ae){D.push(F(ae))},j=function(ae){H.push(F(ae))};function _e(){++xe,te||fe==xe&&b.loseContext()}function Ae(ae,pe){var Se=ae[pe];return function(){if(_e(),!te)return Se.apply(ae,arguments)}}function De(ae){return{statusMessage:ae,preventDefault:function(){He=!0}}}return pe=(ae=b).addEventListener,ae.addEventListener=function(Se,Ze,Je){switch(Se){case"webglcontextlost":z(Ze);break;case"webglcontextrestored":j(Ze);break;default:pe.apply(ae,arguments)}},b.loseContext=function(){if(!te){for(te=!0,fe=0,++Q;X.getError(););(function(){for(var ae=Object.keys(Qe),pe=0;pe<ae.length;++pe)delete Qe[ae]})(),Qe[X.CONTEXT_LOST_WEBGL]=!0;var ae=De("context lost"),pe=D.slice();setTimeout(function(){for(var Se=0;Se<pe.length;++Se)pe[Se](ae);ze>=0&&setTimeout(function(){b.restoreContext()},ze)},0)}},b.restoreContext=function(){te&&H.length&&setTimeout(function(){if(!He)throw"can not restore. webglcontestlost listener did not call event.preventDefault";(function(){for(var ae=0;ae<ge.length;++ae){var pe=ge[ae];pe instanceof WebGLBuffer?X.deleteBuffer(pe):pe instanceof WebGLFramebuffer?X.deleteFramebuffer(pe):pe instanceof WebGLProgram?X.deleteProgram(pe):pe instanceof WebGLRenderbuffer?X.deleteRenderbuffer(pe):pe instanceof WebGLShader?X.deleteShader(pe):pe instanceof WebGLTexture&&X.deleteTexture(pe)}})(),Et(X),te=!1,xe=0,He=!1;for(var ae=H.slice(),pe=De("context restored"),Se=0;Se<ae.length;++Se)ae[Se](pe)},0)},b.loseContextInNCalls=function(ae){if(te)throw"You can not ask a lost contet to be lost";fe=xe+ae},b.getNumCalls=function(){return xe},b.setRestoreTimeout=function(ae){ze=ae},b;function ye(ae){for(var pe in ae)"function"==typeof ae[pe]?N[pe]=Ae(ae,pe):yt(N,ae,pe);N.getError=function(){if(_e(),!te)for(;Ce=X.getError();)Qe[Ce]=!0;for(var Ce in Qe)if(Qe[Ce])return delete Qe[Ce],Ce;return N.NO_ERROR};for(var Se=["createBuffer","createFramebuffer","createProgram","createRenderbuffer","createShader","createTexture"],Ze=0;Ze<Se.length;++Ze){var Je=Se[Ze];N[Je]=function(Ce){return function(){if(_e(),te)return null;var _t=Ce.apply(ae,arguments);return _t.__webglDebugContextLostId__=Q,ge.push(_t),_t}}(ae[Je])}var pt=["getActiveAttrib","getActiveUniform","getBufferParameter","getContextAttributes","getAttachedShaders","getFramebufferAttachmentParameter","getParameter","getProgramParameter","getProgramInfoLog","getRenderbufferParameter","getShaderParameter","getShaderInfoLog","getShaderSource","getTexParameter","getUniform","getUniformLocation","getVertexAttrib"];for(Ze=0;Ze<pt.length;++Ze)N[Je=pt[Ze]]=function(Ce){return function(){return _e(),te?null:Ce.apply(ae,arguments)}}(N[Je]);var Ce,gt=["isBuffer","isEnabled","isFramebuffer","isProgram","isRenderbuffer","isShader","isTexture"];for(Ze=0;Ze<gt.length;++Ze)N[Je=gt[Ze]]=function(Ce){return function(){return _e(),!te&&Ce.apply(ae,arguments)}}(N[Je]);return N.checkFramebufferStatus=(Ce=N.checkFramebufferStatus,function(){return _e(),te?N.FRAMEBUFFER_UNSUPPORTED:Ce.apply(ae,arguments)}),N.getAttribLocation=function(Ce){return function(){return _e(),te?-1:Ce.apply(ae,arguments)}}(N.getAttribLocation),N.getVertexAttribOffset=function(Ce){return function(){return _e(),te?0:Ce.apply(ae,arguments)}}(N.getVertexAttribOffset),N.isContextLost=function(){return te},N}},resetToInitialState:Et}}())&&(ne.exports=se);var Re=v(11173);class $e{constructor(we){this.context=we,this.svgAlwaysPremultipliesAlpha=!1,this.floatBufferBlendWorking=!1,this._doublePrecisionRequiresObfuscation=null,this.floatBufferBlendWorking=function(ce){var we,ee,ue,tt,nt;if(!ce.gl)return!1;if("webgl"===ce.webglVersion)return(null==(tt=ce.capabilities.textureFloat)?void 0:tt.textureFloat)&&(null==(nt=ce.capabilities.colorBufferFloat)?void 0:nt.textureFloat);if(!((null==(we=ce.capabilities.textureFloat)?void 0:we.textureFloat)&&(null==(ee=ce.capabilities.colorBufferFloat)?void 0:ee.textureFloat)&&(null==(ue=ce.capabilities.colorBufferFloat)?void 0:ue.floatBlend)))return!1;const ut=new B.Z(ce,{colorTarget:0,depthStencilTarget:0},{target:3553,wrapMode:33071,pixelFormat:6408,dataType:5126,internalFormat:34836,samplingMode:9728,width:1,height:1}),xt=U.Z.createVertex(ce,35044,new Uint16Array([0,0,1,0,0,1,1,1])),Ee=new G.Z(ce,new Map([["a_pos",0]]),{geometry:[{name:"a_pos",count:2,type:5123,offset:0,stride:4,normalized:!1}]},{geometry:xt}),Ye=new P.$(ce,"\n  precision highp float;\n  attribute vec2 a_pos;\n\n  void main() {\n    gl_Position = vec4(a_pos * 2.0 - 1.0, 0.0, 1.0);\n  }\n  ","\n   precision highp float;\n\n   void main() {\n    gl_FragColor = vec4(0.5, 0.5, 0.5, 0.5);\n   }\n  ",new Map([["a_pos",0]]));ce.useProgram(Ye);const Tt=ce.getBoundFramebufferObject(),{x:yt,y:bt,width:Et,height:V}=ce.getViewport();ce.bindFramebuffer(ut),ce.setViewport(0,0,1,1),ce.bindVAO(Ee),ce.drawArrays(5,0,4);const b=(0,x.sm)({blending:Y.IB});ce.setPipelineState(b),ce.drawArrays(5,0,4),Pe.exports.init(ce);const X=ce.gl.getError();return ce.setViewport(yt,bt,Et,V),ce.bindFramebuffer(Tt),Ye.dispose(),Ee.dispose(!1),xt.dispose(),ut.dispose(),1282!==X||(console.warn("Device claims support for WebGL extension EXT_float_blend but does not support it. Using fall back."),!1)}(we),(0,Re.M)(we).then(ee=>this.svgAlwaysPremultipliesAlpha=!ee)}get doublePrecisionRequiresObfuscation(){if((0,y.Wi)(this._doublePrecisionRequiresObfuscation)){const we=We(this.context,!1),ee=We(this.context,!0);this._doublePrecisionRequiresObfuscation=0!==we&&(0===ee||we/ee>5)}return this._doublePrecisionRequiresObfuscation}}let Te=null;function We(ce,we){const ee=new B.Z(ce,{colorTarget:0,depthStencilTarget:0},{target:3553,wrapMode:33071,pixelFormat:6408,dataType:5121,samplingMode:9728,width:1,height:1}),tt=U.Z.createVertex(ce,35044,new Uint16Array([0,0,1,0,0,1,1,1])),nt=new G.Z(ce,new Map([["position",0]]),{geometry:[{name:"position",count:2,type:5123,offset:0,stride:4,normalized:!1}]},{geometry:tt}),ut=(0,I.f)(5633261.287538229,2626832.878767164,1434988.0495278358),xt=(0,I.f)(5633271.46742708,2626873.6381334523,1434963.231608387),Ee=function(A,D){const H=new P.$(ce,`\n\n  precision highp float;\n\n  attribute vec2 position;\n\n  uniform vec3 u_highA;\n  uniform vec3 u_lowA;\n  uniform vec3 u_highB;\n  uniform vec3 u_lowB;\n\n  varying vec4 v_color;\n\n  ${we?"#define DOUBLE_PRECISION_REQUIRES_OBFUSCATION":""}\n\n  #ifdef DOUBLE_PRECISION_REQUIRES_OBFUSCATION\n\n  vec3 dpPlusFrc(vec3 a, vec3 b) {\n    return mix(a, a + b, vec3(notEqual(b, vec3(0))));\n  }\n\n  vec3 dpMinusFrc(vec3 a, vec3 b) {\n    return mix(vec3(0), a - b, vec3(notEqual(a, b)));\n  }\n\n  vec3 dpAdd(vec3 hiA, vec3 loA, vec3 hiB, vec3 loB) {\n    vec3 t1 = dpPlusFrc(hiA, hiB);\n    vec3 e = dpMinusFrc(t1, hiA);\n    vec3 t2 = dpMinusFrc(hiB, e) + dpMinusFrc(hiA, dpMinusFrc(t1, e)) + loA + loB;\n    return t1 + t2;\n  }\n\n  #else\n\n  vec3 dpAdd(vec3 hiA, vec3 loA, vec3 hiB, vec3 loB) {\n    vec3 t1 = hiA + hiB;\n    vec3 e = t1 - hiA;\n    vec3 t2 = ((hiB - e) + (hiA - (t1 - e))) + loA + loB;\n    return t1 + t2;\n  }\n\n  #endif\n\n  const float MAX_RGBA_FLOAT =\n    255.0 / 256.0 +\n    255.0 / 256.0 / 256.0 +\n    255.0 / 256.0 / 256.0 / 256.0 +\n    255.0 / 256.0 / 256.0 / 256.0 / 256.0;\n\n  const vec4 FIXED_POINT_FACTORS = vec4(1.0, 256.0, 256.0 * 256.0, 256.0 * 256.0 * 256.0);\n\n  vec4 float2rgba(const float value) {\n    // Make sure value is in the domain we can represent\n    float valueInValidDomain = clamp(value, 0.0, MAX_RGBA_FLOAT);\n\n    // Decompose value in 32bit fixed point parts represented as\n    // uint8 rgba components. Decomposition uses the fractional part after multiplying\n    // by a power of 256 (this removes the bits that are represented in the previous\n    // component) and then converts the fractional part to 8bits.\n    vec4 fixedPointU8 = floor(fract(valueInValidDomain * FIXED_POINT_FACTORS) * 256.0);\n\n    // Convert uint8 values (from 0 to 255) to floating point representation for\n    // the shader\n    const float toU8AsFloat = 1.0 / 255.0;\n\n    return fixedPointU8 * toU8AsFloat;\n  }\n\n  void main() {\n    vec3 val = dpAdd(u_highA, u_lowA, -u_highB, -u_lowB);\n\n    v_color = float2rgba(val.z / 25.0);\n\n    gl_Position = vec4(position * 2.0 - 1.0, 0.0, 1.0);\n  }\n  `,"\n  precision highp float;\n\n  varying vec4 v_color;\n\n  void main() {\n    gl_FragColor = v_color;\n  }\n  ",new Map([["position",0]])),N=new Float32Array(6);(0,k.LF)(A,N,3);const Q=new Float32Array(6);return(0,k.LF)(D,Q,3),ce.useProgram(H),H.setUniform3f("u_highA",N[0],N[2],N[4]),H.setUniform3f("u_lowA",N[1],N[3],N[5]),H.setUniform3f("u_highB",Q[0],Q[2],Q[4]),H.setUniform3f("u_lowB",Q[1],Q[3],Q[5]),H}(ut,xt),Ye=ce.getBoundFramebufferObject(),{x:Tt,y:yt,width:bt,height:Et}=ce.getViewport();ce.bindFramebuffer(ee),ce.setViewport(0,0,1,1),ce.bindVAO(nt),ce.drawArrays(5,0,4);const V=new Uint8Array(4);ee.readPixels(0,0,1,1,6408,5121,V),Ee.dispose(),nt.dispose(!1),tt.dispose(),ee.dispose(),ce.setViewport(Tt,yt,bt,Et),ce.bindFramebuffer(Ye);const b=(ut[2]-xt[2])/25,X=(0,K.vP)(V);return Math.abs(b-X)}function ie({code:ce},we){ce.add(we.doublePrecisionRequiresObfuscation?W.H`vec3 dpPlusFrc(vec3 a, vec3 b) {
return mix(a, a + b, vec3(notEqual(b, vec3(0))));
}
vec3 dpMinusFrc(vec3 a, vec3 b) {
return mix(vec3(0), a - b, vec3(notEqual(a, b)));
}
vec3 dpAdd(vec3 hiA, vec3 loA, vec3 hiB, vec3 loB) {
vec3 t1 = dpPlusFrc(hiA, hiB);
vec3 e = dpMinusFrc(t1, hiA);
vec3 t2 = dpMinusFrc(hiB, e) + dpMinusFrc(hiA, dpMinusFrc(t1, e)) + loA + loB;
return t1 + t2;
}`:W.H`vec3 dpAdd(vec3 hiA, vec3 loA, vec3 hiB, vec3 loB) {
vec3 t1 = hiA + hiB;
vec3 e = t1 - hiA;
vec3 t2 = ((hiB - e) + (hiA - (t1 - e))) + loA + loB;
return t1 + t2;
}`)}function de(ce){return!!(0,C.Z)("force-double-precision-obfuscation")||function(ce){return((0,y.Wi)(Te)||Te.context!==ce)&&(Te=new $e(ce)),Te}(ce).doublePrecisionRequiresObfuscation}},72555:(me,$,v)=>{v.d($,{a:()=>y});var C=v(97561),W=v(36320);function y(I,U){const B=C.H`
  /*
  *  ${U.name}
  *  ${0===U.output?"RenderOutput: Color":1===U.output?"RenderOutput: Depth":3===U.output?"RenderOutput: Shadow":2===U.output?"RenderOutput: Normal":4===U.output?"RenderOutput: Highlight":""}
  */
  `;(0,W.CG)()&&(I.fragment.code.add(B),I.vertex.code.add(B))}},97288:(me,$,v)=>{v.d($,{y:()=>y});var C=v(97561);function W(I){I.code.add(C.H`vec4 premultiplyAlpha(vec4 v) {
return vec4(v.rgb * v.a, v.a);
}
vec3 rgb2hsv(vec3 c) {
vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);
vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);
vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);
float d = q.x - min(q.w, q.y);
float e = 1.0e-10;
return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), min(d / (q.x + e), 1.0), q.x);
}
vec3 hsv2rgb(vec3 c) {
vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);
vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);
return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);
}
float rgb2v(vec3 c) {
return max(c.x, max(c.y, c.z));
}`)}function y(I){I.include(W),I.code.add(C.H`
    vec3 mixExternalColor(vec3 internalColor, vec3 textureColor, vec3 externalColor, int mode) {
      // workaround for artifacts in OSX using Intel Iris Pro
      // see: https://devtopia.esri.com/WebGIS/arcgis-js-api/issues/10475
      vec3 internalMixed = internalColor * textureColor;
      vec3 allMixed = internalMixed * externalColor;

      if (mode == ${C.H.int(1)}) {
        return allMixed;
      }
      else if (mode == ${C.H.int(2)}) {
        return internalMixed;
      }
      else if (mode == ${C.H.int(3)}) {
        return externalColor;
      }
      else {
        // tint (or something invalid)
        float vIn = rgb2v(internalMixed);
        vec3 hsvTint = rgb2hsv(externalColor);
        vec3 hsvOut = vec3(hsvTint.x, hsvTint.y, vIn * hsvTint.z);
        return hsv2rgb(hsvOut);
      }
    }

    float mixExternalOpacity(float internalOpacity, float textureOpacity, float externalOpacity, int mode) {
      // workaround for artifacts in OSX using Intel Iris Pro
      // see: https://devtopia.esri.com/WebGIS/arcgis-js-api/issues/10475
      float internalMixed = internalOpacity * textureOpacity;
      float allMixed = internalMixed * externalOpacity;

      if (mode == ${C.H.int(2)}) {
        return internalMixed;
      }
      else if (mode == ${C.H.int(3)}) {
        return externalOpacity;
      }
      else {
        // multiply or tint (or something invalid)
        return allMixed;
      }
    }
  `)}},5190:(me,$,v)=>{v.d($,{n:()=>W});var C=v(97561);function W(y){y.code.add(C.H`const float MAX_RGBA_FLOAT =
255.0 / 256.0 +
255.0 / 256.0 / 256.0 +
255.0 / 256.0 / 256.0 / 256.0 +
255.0 / 256.0 / 256.0 / 256.0 / 256.0;
const vec4 FIXED_POINT_FACTORS = vec4(1.0, 256.0, 256.0 * 256.0, 256.0 * 256.0 * 256.0);
vec4 float2rgba(const float value) {
float valueInValidDomain = clamp(value, 0.0, MAX_RGBA_FLOAT);
vec4 fixedPointU8 = floor(fract(valueInValidDomain * FIXED_POINT_FACTORS) * 256.0);
const float toU8AsFloat = 1.0 / 255.0;
return fixedPointU8 * toU8AsFloat;
}
const vec4 RGBA_2_FLOAT_FACTORS = vec4(
255.0 / (256.0),
255.0 / (256.0 * 256.0),
255.0 / (256.0 * 256.0 * 256.0),
255.0 / (256.0 * 256.0 * 256.0 * 256.0)
);
float rgba2float(vec4 rgba) {
return dot(rgba, RGBA_2_FLOAT_FACTORS);
}`)}},28763:(me,$,v)=>{v.d($,{kG:()=>I});const W=v(33870).Z.getLogger("esri.views.3d.webgl-engine.core.shaderModules.shaderBuilder");class y{constructor(){this.includedModules=new Map}include(Y,ne){this.includedModules.has(Y)?this.includedModules.get(Y)!==ne&&W.error("Trying to include shader module multiple times with different sets of options."):(this.includedModules.set(Y,ne),Y(this.builder,ne))}}class I extends y{constructor(){super(...arguments),this.vertex=new P,this.fragment=new P,this.attributes=new T,this.varyings=new O,this.extensions=new x,this.constants=new M}get fragmentUniforms(){return this.fragment.uniforms}get builder(){return this}generateSource(Y){const ne=this.extensions.generateSource(Y),q=this.attributes.generateSource(Y),se=this.varyings.generateSource(),Pe="vertex"===Y?this.vertex:this.fragment,Ke=Pe.uniforms.generateSource(),Re=Pe.code.generateSource(),$e="vertex"===Y?k:G,Te=this.constants.generateSource().concat(Pe.constants.generateSource());return`\n${ne.join("\n")}\n\n${$e}\n\n${Te.join("\n")}\n\n${Ke.join("\n")}\n\n${q.join("\n")}\n\n${se.join("\n")}\n\n${Re.join("\n")}`}}class U{constructor(){this._entries=new Map}add(Y,ne,q){return this._entries.set(`${Y}_${ne}_${q}`,{name:Y,type:ne,arraySize:q}),this}generateSource(){return Array.from(this._entries.values()).map(ne=>`uniform ${ne.type} ${ne.name}${(ne=>ne?`[${ne}]`:"")(ne.arraySize)};`)}get entries(){return Array.from(this._entries.values())}}class B{constructor(){this._entries=new Array}add(Y){this._entries.push(Y)}generateSource(){return this._entries}}class P extends y{constructor(){super(...arguments),this.uniforms=new U,this.code=new B,this.constants=new M}get builder(){return this}}class T{constructor(){this._entries=new Array}add(Y,ne){this._entries.push([Y,ne])}generateSource(Y){return"fragment"===Y?[]:this._entries.map(ne=>`attribute ${ne[1]} ${ne[0]};`)}}class O{constructor(){this._entries=new Array}add(Y,ne){this._entries.push([Y,ne])}generateSource(){return this._entries.map(Y=>`varying ${Y[1]} ${Y[0]};`)}}class x{constructor(){this._entries=new Set}add(Y){this._entries.add(Y)}generateSource(Y){const ne="vertex"===Y?x.ALLOWLIST_VERTEX:x.ALLOWLIST_FRAGMENT;return Array.from(this._entries).filter(q=>ne.includes(q)).map(q=>`#extension ${q} : enable`)}}x.ALLOWLIST_FRAGMENT=["GL_EXT_shader_texture_lod","GL_OES_standard_derivatives"],x.ALLOWLIST_VERTEX=[];class M{constructor(){this._entries=[]}add(Y,ne,q){let se="ERROR_CONSTRUCTOR_STRING";switch(ne){case"float":se=M.numberToFloatStr(q);break;case"int":se=M.numberToIntStr(q);break;case"bool":se=q.toString();break;case"vec2":se=`vec2(${M.numberToFloatStr(q[0])},                            ${M.numberToFloatStr(q[1])})`;break;case"vec3":se=`vec3(${M.numberToFloatStr(q[0])},                            ${M.numberToFloatStr(q[1])},                            ${M.numberToFloatStr(q[2])})`;break;case"vec4":se=`vec4(${M.numberToFloatStr(q[0])},                            ${M.numberToFloatStr(q[1])},                            ${M.numberToFloatStr(q[2])},                            ${M.numberToFloatStr(q[3])})`;break;case"ivec2":se=`ivec2(${M.numberToIntStr(q[0])},                             ${M.numberToIntStr(q[1])})`;break;case"ivec3":se=`ivec3(${M.numberToIntStr(q[0])},                             ${M.numberToIntStr(q[1])},                             ${M.numberToIntStr(q[2])})`;break;case"ivec4":se=`ivec4(${M.numberToIntStr(q[0])},                             ${M.numberToIntStr(q[1])},                             ${M.numberToIntStr(q[2])},                             ${M.numberToIntStr(q[3])})`;break;case"mat2":case"mat3":case"mat4":se=`${ne}(${Array.prototype.map.call(q,Pe=>M.numberToFloatStr(Pe)).join(", ")})`}return this._entries.push(`const ${ne} ${Y} = ${se};`),this}static numberToIntStr(Y){return Y.toFixed(0)}static numberToFloatStr(Y){return Number.isInteger(Y)?Y.toFixed(1):Y.toString()}generateSource(){return Array.from(this._entries)}}const G="#ifdef GL_FRAGMENT_PRECISION_HIGH\n  precision highp float;\n  precision highp sampler2D;\n#else\n  precision mediump float;\n  precision mediump sampler2D;\n#endif",k="precision highp float;\nprecision highp sampler2D;"},97561:(me,$,v)=>{function C(W,...y){let I="";for(let U=0;U<y.length;U++)I+=W[U]+y[U];return I+=W[W.length-1],I}var W;v.d($,{H:()=>C}),(W=C||(C={})).int=function(U){return Math.round(U).toString()},W.float=function(U){return U.toPrecision(8)}},42683:(me,$,v)=>{v.d($,{$L:()=>U,$x:()=>x,ve:()=>P,IB:()=>I,wu:()=>W,je:()=>O});var C=v(82705);const W=(0,C.wK)(770,1,771,771),y=(0,C.if)(1,1),I=(0,C.if)(0,771);function U(M){return 2===M?null:1===M?I:y}const P=5e5,T={factor:-1,units:-2};function O(M){return M?T:null}function x(M){return 3===M||2===M?513:515}},48557:(me,$,v)=>{v.d($,{hu:()=>x,vP:()=>Ee}),v(22791),v(88034),v(87492),v(64298),v(10127),v(75660),(0,v(82975).c)();class O{constructor(b){this.message=b}toString(){return`AssertException: ${this.message}`}}function x(V,b){if(!V){b=b||"assert";const X=new Error(b);throw X.stack&&console.log(X.stack),new O(b)}}function Ee(V,b=0){let X=0;for(let A=0;A<4;A++)X+=V[b+A]*Tt[A];return X}const Tt=[1/256,1/65536,1/16777216,1/4294967296];Ee(new Uint8ClampedArray([255,255,255,255]))},28258:(me,$,v)=>{function W(P,T,O){for(let x=0;x<O;++x)T[2*x]=P[x],T[2*x+1]=P[x]-T[2*x]}function I(P,T,O,x){for(let M=0;M<x;++M)U[0]=P[M],W(U,B,1),T[M]=B[0],O[M]=B[1]}v.d($,{LF:()=>W,po:()=>I});const U=new Float64Array(1),B=new Float32Array(2)},13773:(me,$,v)=>{v.d($,{bj:()=>te,FZ:()=>ze,Uf:()=>ge,Bw:()=>Ye,LO:()=>fe,Hx:()=>Q});var C=v(22791),W=v(60305),y=v(6618),I=v(10127),U=v(53781);(0,C.Vl)(10),(0,C.Vl)(12),(0,C.Vl)(70),(0,C.Vl)(40);const Re={scale:0,factor:0,minPixelSize:0,paddingPixels:0};var Te=v(48557),dt=(v(88034),v(4003));v(28258),new Float64Array(3),new Float32Array(6),(0,dt.c)();const Ee=(0,U.Ue)();function Ye(F,z,j,Z,le,_e,Ae){if(!function(F){return!!(0,W.pC)(F)&&!F.visible}(z))if(F.boundingInfo)(0,Te.hu)(0===F.primitiveType),yt(F.boundingInfo,Z,le,j.tolerance,_e,Ae);else{const be=F.indices.get("position"),De=F.vertexAttributes.get("position");Et(Z,le,0,be.length/3,be,De,void 0,_e,Ae)}}const Tt=(0,I.c)();function yt(F,z,j,Z,le,_e){if((0,W.Wi)(F))return;const Ae=function(F,z,j){return(0,y.s)(j,1/(z[0]-F[0]),1/(z[1]-F[1]),1/(z[2]-F[2]))}(z,j,Tt);if((0,U.op)(Ee,F.getBBMin()),(0,U.Tn)(Ee,F.getBBMax()),(0,W.pC)(le)&&le.applyToAabb(Ee),function(F,z,j,Z){return function(F,z,j,Z,le){const _e=(F[0]-Z-z[0])*j[0],Ae=(F[3]+Z-z[0])*j[0];let be=Math.min(_e,Ae),De=Math.max(_e,Ae);const ye=(F[1]-Z-z[1])*j[1],ae=(F[4]+Z-z[1])*j[1];if(De=Math.min(De,Math.max(ye,ae)),De<0||(be=Math.max(be,Math.min(ye,ae)),be>De))return!1;const pe=(F[2]-Z-z[2])*j[2],Se=(F[5]+Z-z[2])*j[2];return De=Math.min(De,Math.max(pe,Se)),!(De<0)&&(be=Math.max(be,Math.min(pe,Se)),!(be>De)&&be<1/0)}(F,z,j,Z)}(Ee,z,Ae,Z)){const{primitiveIndices:be,indices:De,position:ye}=F,ae=be?be.length:De.length/3;if(ae>Qe){const pe=F.getChildren();if(void 0!==pe){for(let Se=0;Se<8;++Se)void 0!==pe[Se]&&yt(pe[Se],z,j,Z,le,_e);return}}Et(z,j,0,ae,De,ye,be,le,_e)}}const bt=(0,I.c)();function Et(F,z,j,Z,le,_e,Ae,be,De){if(Ae)return function(F,z,j,Z,le,_e,Ae,be,De){const ye=_e.data,ae=_e.stride||_e.size,pe=F[0],Se=F[1],Ze=F[2],Je=z[0]-pe,pt=z[1]-Se,gt=z[2]-Ze;for(let Ce=j;Ce<Z;++Ce){const _t=Ae[Ce];let ht=3*_t,at=ae*le[ht++],Mt=ye[at++],vt=ye[at++],It=ye[at];at=ae*le[ht++];let $t=ye[at++],Xt=ye[at++],Zt=ye[at];at=ae*le[ht];let Ht=ye[at++],Nt=ye[at++],Rt=ye[at];(0,W.pC)(be)&&([Mt,vt,It]=be.applyToVertex(Mt,vt,It,Ce),[$t,Xt,Zt]=be.applyToVertex($t,Xt,Zt,Ce),[Ht,Nt,Rt]=be.applyToVertex(Ht,Nt,Rt,Ce));const Ot=$t-Mt,wt=Xt-vt,Ft=Zt-It,St=Ht-Mt,Bt=Nt-vt,kt=Rt-It,Jt=pt*kt-Bt*gt,Yt=gt*St-kt*Je,Pt=Je*Bt-St*pt,Ge=Ot*Jt+wt*Yt+Ft*Pt;if(Math.abs(Ge)<=Number.EPSILON)continue;const Ut=pe-Mt,Wt=Se-vt,At=Ze-It,Dt=Ut*Jt+Wt*Yt+At*Pt;if(Ge>0){if(Dt<0||Dt>Ge)continue}else if(Dt>0||Dt<Ge)continue;const qt=Wt*Ft-wt*At,Qt=At*Ot-Ft*Ut,Vt=Ut*wt-Ot*Wt,Ct=Je*qt+pt*Qt+gt*Vt;if(Ge>0){if(Ct<0||Dt+Ct>Ge)continue}else if(Ct>0||Dt+Ct<Ge)continue;const nr=(St*qt+Bt*Qt+kt*Vt)/Ge;nr>=0&&De(nr,A(Ot,wt,Ft,St,Bt,kt,bt),_t)}}(F,z,j,Z,le,_e,Ae,be,De);const ye=_e.data,ae=_e.stride||_e.size,pe=F[0],Se=F[1],Ze=F[2],Je=z[0]-pe,pt=z[1]-Se,gt=z[2]-Ze;for(let Ce=j,_t=3*j;Ce<Z;++Ce){let ht=ae*le[_t++],at=ye[ht++],Mt=ye[ht++],vt=ye[ht];ht=ae*le[_t++];let It=ye[ht++],$t=ye[ht++],Xt=ye[ht];ht=ae*le[_t++];let Zt=ye[ht++],Ht=ye[ht++],Nt=ye[ht];(0,W.pC)(be)&&([at,Mt,vt]=be.applyToVertex(at,Mt,vt,Ce),[It,$t,Xt]=be.applyToVertex(It,$t,Xt,Ce),[Zt,Ht,Nt]=be.applyToVertex(Zt,Ht,Nt,Ce));const Rt=It-at,Ot=$t-Mt,wt=Xt-vt,Ft=Zt-at,St=Ht-Mt,Bt=Nt-vt,kt=pt*Bt-St*gt,Jt=gt*Ft-Bt*Je,Yt=Je*St-Ft*pt,Pt=Rt*kt+Ot*Jt+wt*Yt;if(Math.abs(Pt)<=Number.EPSILON)continue;const Ge=pe-at,Ut=Se-Mt,Wt=Ze-vt,At=Ge*kt+Ut*Jt+Wt*Yt;if(Pt>0){if(At<0||At>Pt)continue}else if(At>0||At<Pt)continue;const Dt=Ut*wt-Ot*Wt,qt=Wt*Rt-wt*Ge,Qt=Ge*Ot-Rt*Ut,Vt=Je*Dt+pt*qt+gt*Qt;if(Pt>0){if(Vt<0||At+Vt>Pt)continue}else if(Vt>0||At+Vt<Pt)continue;const Ct=(Ft*Dt+St*qt+Bt*Qt)/Pt;Ct>=0&&De(Ct,A(Rt,Ot,wt,Ft,St,Bt,bt),Ce)}}const b=(0,I.c)(),X=(0,I.c)();function A(F,z,j,Z,le,_e,Ae){return(0,y.s)(b,F,z,j),(0,y.s)(X,Z,le,_e),(0,y.c)(Ae,b,X),(0,y.n)(Ae,Ae),Ae}function Q(F,z,j,Z,le){let _e=(j.screenLength||0)*F.pixelRatio;le&&(_e=function(F,z,j,Z){return function(F,z){return Math.max((0,C.t7)(F*z.scale,F,z.factor),function(F,z){return 0===F?z.minPixelSize:z.minPixelSize*(1+2*z.paddingPixels/F)}(F,z))}(F,function(F,z,j){const Z=j.parameters,le=j.paddingPixelsOverride;return Re.scale=Math.min(Z.divisor/(z-Z.offset),1),Re.factor=function(F){return Math.abs(F*F*F)}(F),Re.minPixelSize=Z.minPixelSize,Re.paddingPixels=le,Re}(z,j,Z))}(_e,Z,z,le));const Ae=_e*Math.tan(.5*F.fovY)/(.5*F.fullHeight);return(0,C.uZ)(Ae*z,j.minWorldLength||0,null!=j.maxWorldLength?j.maxWorldLength:1/0)}function te(F,z,j){if(!F)return;const Z=F.parameters;z.setUniform4f(j,Z.divisor,Z.offset,Z.minPixelSize,F.paddingPixelsOverride)}function ge(F,z){const j=z?ge(z):{};for(const Z in F){let le=F[Z];le&&le.forEach&&(le=He(le)),null==le&&Z in j||(j[Z]=le)}return j}function fe(F,z){let j=!1;for(const Z in z){const le=z[Z];void 0!==le&&(j=!0,F[Z]=Array.isArray(le)?le.slice():le)}return j}function He(F){const z=[];return F.forEach(j=>z.push(j)),z}const ze={multiply:1,ignore:2,replace:3,tint:4},Qe=1e3},13006:(me,$,v)=>{v.d($,{Z:()=>P});var C=v(22791),W=v(60305),y=v(36320),I=v(40150),U=v(70517);class P{constructor(x,M,G=null){this._context=x,this.type="texture",this._glName=null,this._descriptor=void 0,this._samplingModeDirty=!1,this._wrapModeDirty=!1,x.instanceCounter.increment(I._g.Texture,this),this._descriptor=Lt({target:3553,samplingMode:9729,wrapMode:10497,flipped:!1,hasMipmap:!1,isOpaque:!1,unpackAlignment:4,preMultiplyAlpha:!1},M),34067===this._descriptor.target?this.setDataCubeMap(G):this.setData(G)}get glName(){return this._glName}get descriptor(){return this._descriptor}dispose(){this._context.gl&&this._glName&&(this._context.unbindTextureAllUnits(this),this._context.gl.deleteTexture(this._glName),this._glName=null,this._context.instanceCounter.decrement(I._g.Texture,this))}release(){this.dispose()}resize(x,M){const G=this._descriptor;G.width===x&&G.height===M||(G.width=x,G.height=M,34067===this._descriptor.target?this.setDataCubeMap(null):this.setData(null))}setDataCubeMap(x=null){for(let M=34069;M<=34074;M++)this.setData(x,M)}setData(x,M=3553){if(!this._context||!this._context.gl)return;const G=this._context.gl;this._glName||(this._glName=G.createTexture()),void 0===x&&(x=null),null===x&&(this._descriptor.width=this._descriptor.width||4,this._descriptor.height=this._descriptor.height||4);const k=this._context.bindTexture(this,P.TEXTURE_UNIT_FOR_UPDATES),K=this._descriptor;P._validateTexture(this._context,K),G.pixelStorei(G.UNPACK_ALIGNMENT,K.unpackAlignment),G.pixelStorei(G.UNPACK_FLIP_Y_WEBGL,K.flipped?1:0),G.pixelStorei(G.UNPACK_PREMULTIPLY_ALPHA_WEBGL,K.preMultiplyAlpha?1:0);const Y=K.pixelFormat;let ne=K.internalFormat?K.internalFormat:this._deriveInternalFormat(Y,K.dataType);if(x instanceof ImageData||x instanceof HTMLImageElement||x instanceof HTMLCanvasElement||x instanceof HTMLVideoElement){let q=x.width,se=x.height;x instanceof HTMLVideoElement&&(q=x.videoWidth,se=x.videoHeight),G.texImage2D(M,0,ne,Y,K.dataType,x),(0,y.zu)(G),K.hasMipmap&&this.generateMipmap(),void 0===K.width&&(K.width=q),void 0===K.height&&(K.height=se)}else{null!=K.width&&null!=K.height||console.error("Width and height must be specified!"),G.DEPTH24_STENCIL8&&ne===G.DEPTH_STENCIL&&(ne=G.DEPTH24_STENCIL8);let q=K.width,se=K.height;if((0,W.pC)(O=x)&&"type"in O&&"compressed"===O.type){const Pe=Math.round(Math.log(Math.max(q,se))/Math.LN2)+1;K.hasMipmap=K.hasMipmap&&Pe===x.levels.length;for(let Ke=0;;++Ke){const Re=x.levels[Math.min(Ke,x.levels.length-1)];if(G.compressedTexImage2D(M,Ke,ne,q,se,0,Re),1===q&&1===se||!K.hasMipmap)break;q=Math.max(1,q>>1),se=Math.max(1,se>>1)}}else if((0,W.pC)(x))G.texImage2D(M,0,ne,q,se,0,Y,K.dataType,x),(0,y.zu)(G),K.hasMipmap&&this.generateMipmap();else for(let Pe=0;G.texImage2D(M,Pe,ne,q,se,0,Y,K.dataType,null),(0,y.zu)(G),(1!==q||1!==se)&&K.hasMipmap;++Pe)q=Math.max(1,q>>1),se=Math.max(1,se>>1)}var O;P._applySamplingMode(G,this._descriptor),P._applyWrapMode(G,this._descriptor),P._applyAnisotropicFilteringParameters(this._context,this._descriptor),(0,y.zu)(G),this._context.bindTexture(k,P.TEXTURE_UNIT_FOR_UPDATES)}updateData(x,M,G,k,K,Y,ne=3553){Y||console.error("An attempt to use uninitialized data!"),this._glName||console.error("An attempt to update uninitialized texture!");const q=this._context.gl,se=this._descriptor,Pe=this._context.bindTexture(this,P.TEXTURE_UNIT_FOR_UPDATES);(M<0||G<0||k>se.width||K>se.height||M+k>se.width||G+K>se.height)&&console.error("An attempt to update out of bounds of the texture!"),q.pixelStorei(q.UNPACK_ALIGNMENT,se.unpackAlignment),q.pixelStorei(q.UNPACK_FLIP_Y_WEBGL,se.flipped?1:0),q.pixelStorei(q.UNPACK_PREMULTIPLY_ALPHA_WEBGL,se.preMultiplyAlpha?1:0),Y instanceof ImageData||Y instanceof HTMLImageElement||Y instanceof HTMLCanvasElement||Y instanceof HTMLVideoElement?q.texSubImage2D(ne,x,M,G,se.pixelFormat,se.dataType,Y):q.texSubImage2D(ne,x,M,G,k,K,se.pixelFormat,se.dataType,Y),this._context.bindTexture(Pe,P.TEXTURE_UNIT_FOR_UPDATES)}generateMipmap(){const x=this._descriptor;x.hasMipmap||(x.hasMipmap=!0,this._samplingModeDirty=!0,P._validateTexture(this._context,x)),9729===x.samplingMode?(this._samplingModeDirty=!0,x.samplingMode=9985):9728===x.samplingMode&&(this._samplingModeDirty=!0,x.samplingMode=9984);const M=this._context.bindTexture(this,P.TEXTURE_UNIT_FOR_UPDATES);this._context.gl.generateMipmap(x.target),this._context.bindTexture(M,P.TEXTURE_UNIT_FOR_UPDATES)}setSamplingMode(x){x!==this._descriptor.samplingMode&&(this._descriptor.samplingMode=x,this._samplingModeDirty=!0)}setWrapMode(x){x!==this._descriptor.wrapMode&&(this._descriptor.wrapMode=x,P._validateTexture(this._context,this._descriptor),this._wrapModeDirty=!0)}applyChanges(){const x=this._context.gl,M=this._descriptor;this._samplingModeDirty&&(P._applySamplingMode(x,M),this._samplingModeDirty=!1),this._wrapModeDirty&&(P._applyWrapMode(x,M),this._wrapModeDirty=!1)}_deriveInternalFormat(x,M){if("webgl"===this._context.webglVersion)return x;if(5126===M)switch(x){case 6408:return 34836;case 6407:return 34837;default:throw new Error("Unable to derive format")}return x}static _validateTexture(x,M){(M.width<0||M.height<0)&&console.error("Negative dimension parameters are not allowed!");const G=(0,C.wt)(M.width)&&(0,C.wt)(M.height);(0,U.Z)(x.gl)||G||("number"==typeof M.wrapMode?33071!==M.wrapMode&&console.error("Non-power-of-two textures must have a wrap mode of CLAMP_TO_EDGE!"):33071===M.wrapMode.s&&33071===M.wrapMode.t||console.error("Non-power-of-two textures must have a wrap mode of CLAMP_TO_EDGE!"),M.hasMipmap&&console.error("Mipmapping requires power-of-two textures!"))}static _applySamplingMode(x,M){let G=M.samplingMode,k=M.samplingMode;9985===G||9987===G?(G=9729,M.hasMipmap||(k=9729)):9984!==G&&9986!==G||(G=9728,M.hasMipmap||(k=9728)),x.texParameteri(M.target,x.TEXTURE_MAG_FILTER,G),x.texParameteri(M.target,x.TEXTURE_MIN_FILTER,k)}static _applyWrapMode(x,M){"number"==typeof M.wrapMode?(x.texParameteri(M.target,x.TEXTURE_WRAP_S,M.wrapMode),x.texParameteri(M.target,x.TEXTURE_WRAP_T,M.wrapMode)):(x.texParameteri(M.target,x.TEXTURE_WRAP_S,M.wrapMode.s),x.texParameteri(M.target,x.TEXTURE_WRAP_T,M.wrapMode.t))}static _applyAnisotropicFilteringParameters(x,M){var G;const k=x.capabilities.textureFilterAnisotropic;!k||x.gl.texParameterf(M.target,k.TEXTURE_MAX_ANISOTROPY,null!=(G=M.maxAnisotropy)?G:1)}}P.TEXTURE_UNIT_FOR_UPDATES=0},70517:(me,$,v)=>{function C(W){return window.WebGL2RenderingContext&&W instanceof window.WebGL2RenderingContext}v.d($,{Z:()=>C})},36320:(me,$,v)=>{v.d($,{zu:()=>O,hZ:()=>P,CG:()=>T});var C=v(22795),W=v(67474);const I=v(33870).Z.getLogger("esri/views/webgl"),B=!!(0,W.Z)("enable-feature:webgl-debug");function P(){return B}function T(){return B}function O(x){if(P()){const M=x.getError();if(M){const G=function(x,M){switch(M){case x.INVALID_ENUM:return"Invalid Enum. An unacceptable value has been specified for an enumerated argument.";case x.INVALID_VALUE:return"Invalid Value. A numeric argument is out of range.";case x.INVALID_OPERATION:return"Invalid Operation. The specified command is not allowed for the current state.";case x.INVALID_FRAMEBUFFER_OPERATION:return"Invalid Framebuffer operation. The currently bound framebuffer is not framebuffer complete when trying to render to or to read from it.";case x.OUT_OF_MEMORY:return"Out of memory. Not enough memory is left to execute the command.";case x.CONTEXT_LOST_WEBGL:return"WebGL context has been lost";default:return"Unknown error"}}(x,M),k=(new Error).stack;I.error(new C.Z("webgl-error","WebGL error occured",{message:G,stack:k}))}}}},40150:(me,$,v)=>{v.d($,{Ld:()=>C,Lu:()=>y,_g:()=>W});const C=33984;var W,I;(I=W||(W={}))[I.Texture=0]="Texture",I[I.Buffer=1]="Buffer",I[I.VAO=2]="VAO",I[I.Program=3]="Program",I[I.Framebuffer=4]="Framebuffer",I[I.Renderbuffer=5]="Renderbuffer",I[I.COUNT=6]="COUNT";const y=33306}}]);